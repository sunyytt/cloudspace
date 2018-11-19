package com.example.springclouduser.service.impl;

import com.example.springclouduser.api.MyAuthServiceClient;
import com.example.springclouduser.common.BPwdEncoderUtil;
import com.example.springclouduser.common.JWT;
import com.example.springclouduser.dto.UserLoginDTO;
import com.example.springclouduser.entity.User;
import com.example.springclouduser.repository.UserRepository;
import com.example.springclouduser.service.MyUserServiceDetail;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: sunyy
 * @Date: 2018/11/14 15:09
 * @Description:
 */
@Service
public class MyUserServiceDetailImpl implements MyUserServiceDetail {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyAuthServiceClient client;

    public User insertUser(String username, String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        return userRepository.save(user);
    }

    public UserLoginDTO login(String username, String password){
        User user=userRepository.findByUsername(username);
        if(user==null){
            throw new RuntimeException("用户不存在");
        }
        if(!BPwdEncoderUtil.matches(password, user.getPassword())){
            throw new RuntimeException("用户密码不对");
        }
        //dXNlci1zZXJ2aWNlOjEyMzQ1Ng== 是 user-service:123456的 base64编码
        //user-service:123456 base64编码=dXNlci1zZXJ2aWNlOjEyMzQ1Ng==
        //JWT jwt = client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==", "password", username, password);

        String authorization = "Basic "+new String(Base64.encodeBase64("user-service:123456".getBytes()));
        JWT jwt = client.getToken(authorization, "password", username, password);
        if(jwt==null){
            throw new RuntimeException("用户Token有问题");
        }
        System.out.println("登陆时间:"+new Date());
        UserLoginDTO dto=new UserLoginDTO();
        dto.setUser(user);
        dto.setJwt(jwt);
        return dto;
    }
}
