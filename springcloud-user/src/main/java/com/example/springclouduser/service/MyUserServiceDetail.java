package com.example.springclouduser.service;


import com.example.springclouduser.dto.UserLoginDTO;
import com.example.springclouduser.entity.User;

/**
 * @Auther: sunyy
 * @Date: 2018/11/13 17:20
 * @Description:
 */
public interface MyUserServiceDetail {

    public User insertUser(String username, String password);

    public UserLoginDTO login(String username, String password);



}
