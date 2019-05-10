package com.zhys.rbac.admin.vo;

import com.zhys.rbac.admin.po.SysUser;
import lombok.Data;

import java.io.Serializable;

/**
 * @author diandian
 * @date 2019/05/10
 * <p>
 * commit('SET_ROLES', data)
 * commit('SET_NAME', data)
 * commit('SET_AVATAR', data)
 * commit('SET_INTRODUCTION', data)
 * commit('SET_PERMISSIONS', data)
 */
@Data
public class UserInfoVo implements Serializable {
    /**
     * 用户基本信息
     */
    private SysUser sysUser;
    /**
     * 权限标识集合
     */
    private String[] permissions;

    /**
     * 角色集合
     */
    private String[] roles;
}
