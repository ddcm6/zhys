package com.zhys.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * zuul gateway
 * @Author: diandian
 * @date: 14:11 2019/5/9
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ZhysGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhysGatewayApplication.class, args);
	}
}
