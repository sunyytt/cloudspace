package com.example.springclouduser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @Auther: sunyy
 * @Date: 2018/11/13 17:19
 * @Description:
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法级别安全验证
public class MyGlobalMethodSecurityConfig {
}
