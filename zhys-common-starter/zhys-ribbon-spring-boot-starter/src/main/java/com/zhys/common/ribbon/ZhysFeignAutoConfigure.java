package com.zhys.common.ribbon;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign统一配置
 * @Author: diandian
 * @date: 8:50 2019/5/10
 */
@Configuration
public class ZhysFeignAutoConfigure {

    /**
     * Feign 日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public XlabelFeignHeaderInterceptor xlabelFeignHeaderInterceptor() {
        return new XlabelFeignHeaderInterceptor();
    }
}
