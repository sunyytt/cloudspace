package com.example.springboot.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @Auther: sunyy
 * @Date: 2018/11/16 14:26
 * @Description:
 * 配置需要token验证的资源
 * ResourceServerConfigurerAdapter
 * 继承于 ResourceServerConfigurer
 * ResourceServerConfigurer，用于保护oauth相关的endpoints，同时主要作用于用户的登录（form login，Basic auth）
 */
@Configuration
@EnableResourceServer
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        System.out.println("zuul->MyResourceServerConfig->HttpSecurity");
//        http.requestMatchers().antMatchers("/api/**")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/**").authenticated();
//    }

    @Autowired
    TokenStore tokenStore ;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        System.out.println("zuul->ResourceServerConfigurerAdapter->HttpSecurity");
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/login","/user/register").permitAll()
//                .antMatchers("/auth/**").permitAll()
                .antMatchers("/**").authenticated(); //配置需要token验证的资源
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        System.out.println("zuul->ResourceServerSecurityConfigurer");
        resources.tokenStore(tokenStore);
    }
}
