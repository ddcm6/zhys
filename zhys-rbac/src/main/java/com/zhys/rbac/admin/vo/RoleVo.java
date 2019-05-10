package com.zhys.rbac.admin.vo;

import com.zhys.rbac.admin.po.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色VO
 * @Author: diandian
 * @date: 14:20 2019/5/9
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleVo extends SysRole {
    /**
     * 角色部门Id
     */
    private Integer roleDeptId;

    /**
     * 部门名称
     */
    private String deptName;
}
