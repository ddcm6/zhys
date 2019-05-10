package com.zhys.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * auth2 启动类
 * @Author: diandian
 * @date: 16:44 2019/5/9
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ZhysOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhysOauth2ServerApplication.class, args);
    }
}
