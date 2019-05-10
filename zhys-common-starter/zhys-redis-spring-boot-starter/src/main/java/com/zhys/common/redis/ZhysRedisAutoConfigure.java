package com.zhys.common.redis;

import com.zhys.common.redis.template.ZhysRedisRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis 配置类
 * @Author: diandian
 * @date: 8:49 2019/5/10
 */
@Configuration
@ConditionalOnClass(ZhysRedisRepository.class)
@EnableConfigurationProperties(RedisProperties.class)
public class ZhysRedisAutoConfigure {

    /**
     * Redis repository redis repository.
     *
     * @param redisTemplate the redis template
     * @return the redis repository
     */
    @Bean
    @ConditionalOnMissingBean
    public ZhysRedisRepository redisRepository(RedisTemplate<String, String> redisTemplate) {
        return new ZhysRedisRepository(redisTemplate);
    }
}
