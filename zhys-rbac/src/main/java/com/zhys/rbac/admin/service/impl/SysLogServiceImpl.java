package com.zhys.rbac.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhys.common.constants.CommonConstant;
import com.zhys.common.entity.SysLog;
import com.zhys.rbac.admin.dao.SysLogDao;
import com.zhys.rbac.admin.service.SysLogService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 日志表 服务实现类
 * @Author: diandian
 * @date: 14:52 2019/5/9
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLog> implements SysLogService {

    @Override
    public Boolean updateByLogId(Long id) {
        SysLog sysLog = new SysLog();
        sysLog.setId(id);
        sysLog.setDelFlag(CommonConstant.STATUS_DEL);
        sysLog.setUpdateTime(new Date());
        return updateById(sysLog);
    }
}
