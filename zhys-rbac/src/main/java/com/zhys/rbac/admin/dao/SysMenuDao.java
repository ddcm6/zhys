package com.zhys.rbac.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhys.common.vo.MenuVo;
import com.zhys.rbac.admin.po.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单权限表 Mapper 接口
 * @Author: diandian
 * @date: 14:27 2019/5/9
 */
public interface SysMenuDao extends BaseMapper<SysMenu> {

    /**
     * 通过角色名查询菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    List<MenuVo> findMenuByRoleName(@Param("role") String role);
}
