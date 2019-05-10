package com.zhys.rbac.admin.vo;

import com.zhys.rbac.admin.po.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoExtendVo extends SysUser {
    /**
     * 角色ID
     */
    private List<Integer> role;

    private Integer deptId;

    /**
     * 新密码
     */
    private String newpassword1;
}
