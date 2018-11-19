package com.example.springclouduser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @Auther: sunyy
 * @Date: 2018/11/13 17:13
 * @Description:
 * 配置资源服务器
 */
//@Configuration
//@EnableResourceServer
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

//    @Autowired
//    TokenStore tokenStore ;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        System.out.println("user->ResourceServerConfigurerAdapter->HttpSecurity");
        http.csrf().disable();
//                .authorizeRequests()
//                .antMatchers("/login","/register").permitAll()
//                .antMatchers("/**").authenticated();
    }

//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources){
//        System.out.println("user->ResourceServerSecurityConfigurer");
//        resources.tokenStore(tokenStore);
//    }
}
