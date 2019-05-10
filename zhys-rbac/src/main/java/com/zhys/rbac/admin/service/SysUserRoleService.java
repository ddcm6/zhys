package com.zhys.rbac.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhys.rbac.admin.po.SysUserRole;

/**
 * 用户角色表 服务类
 * @Author: diandian
 * @date: 14:34 2019/5/9
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 根据用户Id删除该用户的角色关系
     * @Author: diandian
     * @date: 14:34 2019/5/9
     */
    Boolean deleteByUserId(Integer userId);
}
