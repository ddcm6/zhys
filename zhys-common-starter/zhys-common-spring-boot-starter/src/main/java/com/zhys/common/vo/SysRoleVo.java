package com.zhys.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统角色
 * @Author: diandian
 * @date: 9:22 2019/5/10
 */
@Data
public class SysRoleVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String roleDesc;
    private Date createTime;
    private Date updateTime;
    private String delFlag;
}
