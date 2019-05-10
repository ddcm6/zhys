package com.zhys.rbac.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhys.common.constants.CommonConstant;
import com.zhys.common.vo.MenuVo;
import com.zhys.rbac.admin.dao.SysMenuDao;
import com.zhys.rbac.admin.po.SysMenu;
import com.zhys.rbac.admin.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单权限表 服务实现类
 * @Author: diandian
 * @date: 15:28 2019/5/9
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuMapper;

    @Override
    public List<MenuVo> findMenuByRoleName(String role) {
        return sysMenuMapper.findMenuByRoleName(role);
    }

    @Override
    public Boolean deleteMenu(Integer id) {
        // 删除当前节点
        SysMenu condition1 = new SysMenu();
        condition1.setMenuId(id);
        condition1.setDelFlag(CommonConstant.STATUS_DEL);
        this.updateById(condition1);

        // 删除父节点为当前节点的节点
        SysMenu conditon2 = new SysMenu();
        conditon2.setParentId(id);
        SysMenu sysMenu = new SysMenu();
        sysMenu.setDelFlag(CommonConstant.STATUS_DEL);
        return this.update(sysMenu, new EntityWrapper<>(conditon2));
    }

    @Override
    public Boolean updateMenuById(SysMenu sysMenu) {
        return this.updateById(sysMenu);
    }
}
