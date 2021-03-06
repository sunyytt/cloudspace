package com.example.springcloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //@EnableEurekaClient
public class SpringcloudProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProducerApplication.class, args);
    }
}
