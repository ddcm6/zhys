package com.zhys.common.config;

import com.zhys.common.exception.DefaultExceptionAdvice;
import com.zhys.common.resolver.TokenArgumentResolver;
import com.zhys.common.utils.RequestPerformanceFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * zhys 公共配置类, 一些公共工具配置
 * @Author: diandian
 * @date: 18:00 2019/5/9
 */
@Configuration
public class ZhysCommonAutoConfig implements WebMvcConfigurer {

    /**
     * Token参数解析
     *
     * @param argumentResolvers 解析类
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new TokenArgumentResolver());
    }

    @Bean
    @ConditionalOnMissingBean({DefaultExceptionAdvice.class})
    public DefaultExceptionAdvice defaultExceptionAdvice() {
        return new DefaultExceptionAdvice();
    }

    /**
     * 过滤器配置
     */
    @Bean
    @ConditionalOnClass(RequestPerformanceFilter.class)
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<RequestPerformanceFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        RequestPerformanceFilter filter = new RequestPerformanceFilter();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addInitParameter("threshold","3000");
        filterRegistrationBean.addInitParameter("includeQueryString", "true");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
