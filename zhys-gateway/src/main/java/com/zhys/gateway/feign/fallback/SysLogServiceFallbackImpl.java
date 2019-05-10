package com.zhys.gateway.feign.fallback;

import com.zhys.common.entity.SysLog;
import com.zhys.gateway.feign.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysLogServiceFallbackImpl implements SysLogService {

    @Override
    public void add(SysLog sysLog) {
        log.error("调用{}异常{}", "addSysLog", sysLog);
    }
}
