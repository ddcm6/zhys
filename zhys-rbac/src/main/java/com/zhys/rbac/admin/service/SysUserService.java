package com.zhys.rbac.admin.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.xiaoleilu.hutool.system.UserInfo;
import com.zhys.common.utils.Query;
import com.zhys.common.vo.UserVo;
import com.zhys.common.web.Response;
import com.zhys.rbac.admin.po.SysUser;
import com.zhys.rbac.admin.vo.UserInfoExtendVo;
import com.zhys.rbac.admin.vo.UserInfoVo;

/**
 *
 * @Author: diandian
 * @date: 14:35 2019/5/9
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 根据用户名查询用户角色信息
     * @Author: diandian
     * @date: 14:35 2019/5/9
     */
    UserVo findUserByUsername(String username);

    /**
     * 分页查询用户信息（含有角色信息）
     * @Author: diandian
     * @date: 14:35 2019/5/9
     */
    Page selectWithRolePage(Query query, UserVo userVO);

    /**
     * 查询用户信息
     * @Author: diandian
     * @date: 14:35 2019/5/9
     */
    UserInfoVo findUserInfo(UserVo userVo);

    /**
     * 保存验证码
     * @Author: diandian
     * @date: 14:35 2019/5/9
     */
    void saveImageCode(String randomStr, String imageCode);

    /**
     * 删除用户
     * @Author: diandian
     * @date: 14:35 2019/5/9
     */
    Boolean deleteUserById(SysUser sysUser);

    /**
     * 更新当前用户基本信息
     * @Author: diandian
     * @date: 14:35 2019/5/9
     */
    Response updateUserInfo(UserInfoExtendVo userDto, String username);

    /**
     * 更新指定用户信息
     * @Author: diandian
     * @date: 14:35 2019/5/9
     */
    Boolean updateUser(UserInfoExtendVo userDto, String username);

    /**
     * 通过手机号查询用户信息
     * @Author: diandian
     * @date: 14:35 2019/5/9
     */
    UserVo findUserByMobile(String mobile);

    /**
     * 发送验证码
     * @Author: diandian
     * @date: 14:35 2019/5/9
     */
    Response sendSmsCode(String mobile);

    /**
     * 通过openId查询用户
     * @Author: diandian
     * @date: 14:36 2019/5/9
     */
    UserVo findUserByOpenId(String openId);

    /**
     * 通过ID查询用户信息
     * @Author: diandian
     * @date: 14:35 2019/5/9
     */
    UserVo selectUserVoById(Integer id);
}
