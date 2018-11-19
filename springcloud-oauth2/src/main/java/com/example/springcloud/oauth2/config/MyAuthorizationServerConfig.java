package com.example.springcloud.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Auther: sunyy
 * @Date: 2018/11/12 16:50
 * @Description:
 */
@Configuration
@EnableAuthorizationServer // 开启授权服务功能
public class MyAuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    //redis 存储token 1.redis连接工厂
    // 是将token放入redis,jwt是不需要保存的
    //但目前的做法是使用JWT，同时在Redis保存信息，在API网关进行详细的验证；各服务则只简单校验Token本身是否篡改。
    @Autowired
    private RedisConnectionFactory connectionFactory;
    //redis 存储token 2.用于存放token
    @Bean
    public TokenStore redisTokenStore() {
        RedisTokenStore redis = new RedisTokenStore(connectionFactory);
        return redis;
    }


    //mysql配置 1.dataSource是在yml配置文件中配置好了的,只需要注入
    @Resource
    private DataSource dataSource;
    //mysql配置 2.
    @Bean
    public ClientDetailsService clientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    // 配置客户端基本信息
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //这个地方指的是从jdbc查出数据来存储
        //mysql配置 3.
        clients.withClientDetails(clientDetailsService());

//
//        clients.inMemory() // 使用in-memory存储
//                .withClient("user-service") // client_id
//                .secret("123456") // client_secret
//                .authorizedGrantTypes("password","refresh_token") // 该client允许的授权类型  password认证
//                .scopes("service") // 允许的授权范围
//                .accessTokenValiditySeconds(10);

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore())// //从jwt来数据
                .tokenStore(redisTokenStore())
                .tokenEnhancer(jwtAccessTokenConverter())
                .authenticationManager(authenticationManager)
                //该字段设置设置refresh token是否重复使用,true:reuse;false:no reuse.
                .reuseRefreshTokens(true)
        ;
    }

    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    private JwtAccessTokenConverter jwtAccessTokenConverter() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("cnsesan-jwt.jks"),"cnsesan123".toCharArray());
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("cnsesan-jwt"));
        return converter;
    }

}
