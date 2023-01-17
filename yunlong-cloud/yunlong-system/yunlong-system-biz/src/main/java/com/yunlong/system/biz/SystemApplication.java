package com.yunlong.system.biz;

import com.yunlong.frame.feign.annotation.EnableYunLongFeignClients;
import com.yunlong.frame.security.annotation.EnableYunLongResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@EnableYunLongFeignClients
@EnableYunLongResourceServer
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

}
