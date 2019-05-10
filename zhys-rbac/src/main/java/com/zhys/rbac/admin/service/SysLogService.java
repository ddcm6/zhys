package com.zhys.rbac.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhys.common.entity.SysLog;

/**
 * 日志表 服务类
 * @Author: diandian
 * @date: 14:32 2019/5/9
 */
public interface SysLogService extends IService<SysLog> {

    /**
     * 通过ID删除日志（逻辑删除）
     * @Author: diandian
     * @date: 14:32 2019/5/9
     */
    Boolean updateByLogId(Long id);
}
