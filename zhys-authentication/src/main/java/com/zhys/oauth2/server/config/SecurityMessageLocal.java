package com.zhys.oauth2.server.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Security message
 * @Author: diandian
 * @date: 16:48 2019/5/9
 */
@Configuration
public class SecurityMessageLocal {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.addBasenames("classpath:messages/security/messages_zh_CN");
        return messageSource;
    }
}
