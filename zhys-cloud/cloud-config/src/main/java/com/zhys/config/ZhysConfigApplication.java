package com.zhys.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心
 * @Author: diandian
 * @date: 13:55 2019/5/9
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ZhysConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZhysConfigApplication.class, args);
    }
}
