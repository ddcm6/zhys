package com.zhys.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * zhys 服务治理service
 * @Author: diandian
 * @date: 17:52 2019/5/9
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulServer
public class ZhysAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhysAdminApplication.class, args);
    }
}
