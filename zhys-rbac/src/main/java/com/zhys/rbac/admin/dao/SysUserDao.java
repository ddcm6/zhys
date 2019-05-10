package com.zhys.rbac.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhys.common.interceptor.DataScope;
import com.zhys.common.utils.Query;
import com.zhys.common.vo.UserVo;
import com.zhys.rbac.admin.po.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表 Mapper 接口
 * @Author: diandian
 * @date: 14:29 2019/5/9
 */
public interface SysUserDao extends BaseMapper<SysUser> {
    /**
     * 通过用户名查询用户信息（含有角色信息）
     *
     * @param username 用户名
     * @return userVo
     */
    UserVo selectUserVoByUsername(String username);

    /**
     * 分页查询用户信息（含角色）
     *
     * @param query     查询条件
     * @param username  用户名
     * @param dataScope 数据权限
     * @return list
     */
    List selectUserVoPageDataScope(Query query, @Param("username") Object username, DataScope dataScope);

    /**
     * 通过手机号查询用户信息（含有角色信息）
     *
     * @param mobile 用户名
     * @return userVo
     */
    UserVo selectUserVoByMobile(String mobile);

    /**
     * 通过openId查询用户信息
     *
     * @param openId openid
     * @return userVo
     */
    UserVo selectUserVoByOpenId(String openId);

    /**
     * 通过ID查询用户信息
     *
     * @param id 用户ID
     * @return userVo
     */
    UserVo selectUserVoById(Integer id);
}
