package com.zhys.rbac.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhys.common.utils.Query;
import com.zhys.rbac.admin.po.SysRole;

import java.util.List;
import java.util.Map;

/**
 * Mapper 接口
 * @Author: diandian
 * @date: 14:28 2019/5/9
 */
public interface SysRoleDao extends BaseMapper<SysRole> {

    /**
     * 查询角色列表含有部门信息
     * @param query 查询对象
     * @param condition 条件
     * @return List
     */
    List<Object> selectRolePage(Query<Object> query, Map<String, Object> condition);

    /**
     * 通过部门ID查询角色列表
     *
     * @param deptId 部门ID
     * @return 角色列表
     */
    List<SysRole> selectListByDeptId(Integer deptId);
}
