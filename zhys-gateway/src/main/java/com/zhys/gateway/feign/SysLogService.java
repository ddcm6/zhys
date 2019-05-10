package com.zhys.gateway.feign;

import com.zhys.common.constants.ServiceNameConstants;
import com.zhys.common.entity.SysLog;
import com.zhys.gateway.feign.fallback.SysLogServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 系统日志Service
 * @Author: diandian
 * @date: 18:04 2019/5/9
 */
@FeignClient(name = ServiceNameConstants.RBAC_SERVICE, fallback = SysLogServiceFallbackImpl.class)
public interface SysLogService {

    /**
     * 添加日志
     *
     * @param log 日志实体
     */
    @PostMapping("/log")
    void add(@RequestBody SysLog log);
}
