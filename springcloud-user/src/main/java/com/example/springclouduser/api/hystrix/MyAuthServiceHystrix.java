package com.example.springclouduser.api.hystrix;

import com.example.springclouduser.api.MyAuthServiceClient;
import com.example.springclouduser.common.JWT;
import org.springframework.stereotype.Component;

/**
 * @Auther: sunyy
 * @Date: 2018/11/13 17:24
 * @Description:
 */
@Component
public class MyAuthServiceHystrix implements MyAuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {

        System.out.println("进入熔断器......");
        return null;
    }

}