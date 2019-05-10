package com.zhys.rbac.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhys.common.vo.MenuVo;
import com.zhys.rbac.admin.po.SysMenu;

import java.util.List;

/**
 * 菜单权限表 服务类
 * @Author: diandian
 * @date: 14:32 2019/5/9
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 通过角色名称查询URL 权限
     * @Author: diandian
     * @date: 14:33 2019/5/9
     */
    List<MenuVo> findMenuByRoleName(String role);

   /**
    * 级联删除菜单
    * @Author: diandian
    * @date: 14:33 2019/5/9
    */
    Boolean deleteMenu(Integer id);

    /**
     * 更新菜单信息
     * @Author: diandian
     * @date: 14:33 2019/5/9
     */
    Boolean updateMenuById(SysMenu sysMenu);
}
