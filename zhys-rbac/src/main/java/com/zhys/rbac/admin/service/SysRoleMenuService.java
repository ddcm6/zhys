package com.zhys.rbac.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhys.rbac.admin.po.SysRoleMenu;

import java.util.Collection;

/**
 * 角色菜单表 服务类
 * @Author: diandian
 * @date: 14:33 2019/5/9
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 更新角色菜单
     * @Author: diandian
     * @date: 14:33 2019/5/9
     */
    Boolean insertRoleMenus(String role, Integer roleId, Collection<Integer> menuIds);
}
