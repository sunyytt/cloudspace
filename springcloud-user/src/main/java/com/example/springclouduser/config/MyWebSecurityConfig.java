package com.example.springclouduser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Auther: sunyy
 * @Date: 2018/11/14 16:18
 * @Description:
 * 安全配置  WebSecurityConfigurerAdapter
 * 过滤器拦截器区别：
 * 顺序过滤前 - 拦截前 - Action处理 - 拦截后 - 过滤后
 * 在ResourceServerProperties中，定义了它的order默认值为
 * SecurityProperties.ACCESS_OVERRIDE_ORDER - 1;，是大于100的  记住
 * 所以：
 * WebSecurityConfigurerAdapter的拦截要优先于ResourceServerConfigurerAdapter
 * 在WebSecurityConfigurerAdapter不拦截oauth要开放的资源
 * @ Order(100)
 * WebSecurityConfigurerAdapter 是默认情况下Spring security的http配置；
 * ResourceServerConfigurerAdapter 是默认情况下spring security oauth 的http配置。
 */
@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * http安全配置
     * @param http http安全对象
     * @throws Exception http安全异常信息
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("user->MyWebSecurityConfig->HttpSecurity");
        http.csrf().disable();  // 禁用csrf

    }

}
