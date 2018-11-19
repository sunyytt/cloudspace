package com.example.springclouduser.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Auther: sunyy
 * @Date: 2018/11/14 11:34
 * @Description:
 */
@RestController
public class DemoController  {

    @RequestMapping("/hi")
    public String hi(){
        return "hi，你好";
    }

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String hello(){
        return "hello，你好";
    }
    @RequestMapping("/getPrincipal")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oauth2Authentication,
                                             Principal principal,
                                             Authentication authentication){
        System.out.println("====================================");
        System.out.println(oauth2Authentication);
        System.out.println(principal);
        System.out.println(authentication);
        System.out.println("====================================");
        return oauth2Authentication;
    }

}
