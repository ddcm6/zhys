package com.zhys.rbac.admin.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.zhys.common.utils.Query;
import com.zhys.rbac.admin.po.SysRole;
import com.zhys.rbac.admin.vo.RoleVo;

import java.util.List;

/**
 * 服务类
 * @Author: diandian
 * @date: 14:33 2019/5/9
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 添加角色
     * @Author: diandian
     * @date: 14:34 2019/5/9
     */
    Boolean insertRole(RoleVo roleDto);

    /**
     * 分页查角色列表
     * @Author: diandian
     * @date: 14:34 2019/5/9
     */
    Page selectwithDeptPage(Query<Object> objectQuery, EntityWrapper<Object> objectEntityWrapper);

    /**
     * 更新角色
     * @Author: diandian
     * @date: 14:34 2019/5/9
     */
    Boolean updateRoleById(RoleVo roleDto);

    /**
     * 通过部门ID查询角色列表
     * @Author: diandian
     * @date: 14:34 2019/5/9
     */
    List<SysRole> selectListByDeptId(Integer deptId);
}
