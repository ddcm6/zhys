package com.zhys.rbac.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhys.rbac.admin.po.SysUserRole;
import org.apache.ibatis.annotations.Param;

/**
 * 用户角色表 Mapper 接口
 * @Author: diandian
 * @date: 14:29 2019/5/9
 */
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {
    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户ID
     * @return boolean
     * @author 寻欢·李
     * @date 2017年12月7日 16:31:38
     */
    Boolean deleteByUserId(@Param("userId") Integer userId);
}
