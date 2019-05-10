package com.zhys.gateway.config;

import com.zhys.common.redis.template.ZhysRedisRepository;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 动态路由配置类
 * @Author: diandian
 * @date: 18:02 2019/5/9
 */
@Configuration
public class DynamicRouteConfiguration {
    private Registration registration;
    private DiscoveryClient discovery;
    private ZuulProperties zuulProperties;
    private ServerProperties server;
    private ZhysRedisRepository redisRepository;

    public DynamicRouteConfiguration(Registration registration, DiscoveryClient discovery,
                                     ZuulProperties zuulProperties, ServerProperties server, ZhysRedisRepository redisRepository) {
        this.registration = registration;
        this.discovery = discovery;
        this.zuulProperties = zuulProperties;
        this.server = server;
        this.redisRepository = redisRepository;
    }

    @Bean
    public DiscoveryClientRouteLocator dynamicRouteLocator() {
        return new DynamicRouteLocator(
                server.getServlet().getPath()
                , discovery
                , zuulProperties
                , registration
                , redisRepository);
    }
}
