package com.example.springboot.zuul;

import com.example.springboot.zuul.filter.AuthFliter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * API网关服务
 * @ EnableZuulProxy 启用网关路由
 * @ EnableOAuth2Sso 启用OAuth2单点登录
 */
//@EnableResourceServer
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringbootZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootZuulApplication.class, args);
    }


    @Bean
    public AuthFliter authFliter(){
        return new AuthFliter();
    }
}
