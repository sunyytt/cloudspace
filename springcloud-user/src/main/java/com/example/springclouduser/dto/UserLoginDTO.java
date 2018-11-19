package com.example.springclouduser.dto;

import com.example.springclouduser.common.JWT;
import com.example.springclouduser.entity.User;

import java.io.Serializable;

/**
 * @Auther: sunyy
 * @Date: 2018/11/13 17:35
 * @Description:
 */
public class UserLoginDTO implements Serializable {

    private User user;
    private JWT jwt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JWT getJwt() {
        return jwt;
    }

    public void setJwt(JWT jwt) {
        this.jwt = jwt;
    }
}
