package com.example.springclouduser.controller;

import com.example.springclouduser.dto.UserLoginDTO;
import com.example.springclouduser.entity.User;
import com.example.springclouduser.service.MyUserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: sunyy
 * @Date: 2018/11/13 17:34
 * @Description:
 */

@RestController
//@RequestMapping("/user")
public class MyUserController {

    @Autowired
    private MyUserServiceDetail userServiceDetail;

    @PostMapping("/register")
    public User postUser(@RequestParam("username")String username, @RequestParam("password")String password){
        return userServiceDetail.insertUser(username, password);
    }
    @PostMapping ("/login")
    public Object login(@RequestParam ("username")String username, @RequestParam ("password")String password){
        Map<String,Object> result =  new HashMap<>();
        UserLoginDTO dto = userServiceDetail.login(username, password);
        result.put("user",dto.getUser());
        result.put("JWT",dto.getJwt());
        return dto;
    }

}
