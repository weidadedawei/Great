package com.yunlong.auth;

import com.yunlong.frame.feign.annotation.EnableYunLongFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 认证授权中心
 * @author david
 * @date 2023-1-17
 */
@EnableYunLongFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
