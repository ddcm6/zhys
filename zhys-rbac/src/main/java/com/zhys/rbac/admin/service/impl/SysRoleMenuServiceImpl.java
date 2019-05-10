package com.zhys.rbac.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhys.rbac.admin.dao.SysRoleMenuDao;
import com.zhys.rbac.admin.po.SysRoleMenu;
import com.zhys.rbac.admin.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 角色菜单表 服务实现类
 * @Author: diandian
 * @date: 9:18 2019/5/10
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenu> implements SysRoleMenuService {
    @Override
    public Boolean insertRoleMenus(String role, Integer roleId, Collection<Integer> menuIds) {
        SysRoleMenu condition = new SysRoleMenu();
        condition.setRoleId(roleId);
        this.delete(new EntityWrapper<>(condition));

        List<SysRoleMenu> roleMenuList = new ArrayList<>();
        for (Integer menuId : menuIds) {
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuList.add(roleMenu);
        }
        return this.insertBatch(roleMenuList);
    }
}
