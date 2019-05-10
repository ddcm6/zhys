package com.zhys.common.vo;

import com.zhys.common.entity.SysLog;
import lombok.Data;

import java.io.Serializable;

/**
 * 日志记录VO
 * @Author: diandian
 * @date: 15:15 2019/5/9
 */
@Data
public class LogVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private SysLog sysLog;
    private String username;
}
