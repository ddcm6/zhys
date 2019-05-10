package com.zhys.common.redis.limit.config;

import com.zhys.common.redis.constant.RedisToolsConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 限流配置
 * @Author: diandian
 * @date: 17:59 2019/5/9
 */
@Data
@ConfigurationProperties("zhys.redis.limit")
public class RedisLimitProperties {

    private Boolean enabled;
    /**
     * 具体限流value
     */
    private int value;
    /**
     * redis部署类型 1单机 2集群
     */
    private int type = RedisToolsConstant.SINGLE;
}
