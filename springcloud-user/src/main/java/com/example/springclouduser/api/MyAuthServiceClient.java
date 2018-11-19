package com.example.springclouduser.api;

import com.example.springclouduser.common.JWT;
import com.example.springclouduser.api.hystrix.MyAuthServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * MyAuthServiceClient是个接口，使用Feign向 uaa 去请求，同时加以熔断机制进行处理
 */
@FeignClient(value="oauth2", fallback =MyAuthServiceHystrix.class )
public interface MyAuthServiceClient {
//设置超时时间
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })

    /**
     * 获取token
     * @param authorization  client_secret
     * @param type
     * @param username
     * @param password
     * @return JWT
     */
    @PostMapping(value ="/oauth/token")
        JWT getToken(@RequestHeader(value = "Authorization") String authorization,
                     @RequestParam("grant_type") String type,
                     @RequestParam("username") String username,
                     @RequestParam("password") String password);
}
