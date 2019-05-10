package com.zhys.rbac.admin.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.xiaoleilu.hutool.system.UserInfo;
import com.zhys.common.constants.CommonConstant;
import com.zhys.common.utils.Query;
import com.zhys.common.vo.UserVo;
import com.zhys.common.web.BaseController;
import com.zhys.common.web.Response;
import com.zhys.rbac.admin.po.SysUser;
import com.zhys.rbac.admin.po.SysUserRole;
import com.zhys.rbac.admin.service.SysUserService;
import com.zhys.rbac.admin.vo.UserInfoExtendVo;
import com.zhys.rbac.admin.vo.UserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();
    @Autowired
    private SysUserService userService;

    /**
     * 获取当前用户信息（角色、权限）
     * 并且异步初始化用户部门信息
     *
     * @param userVo 当前用户信息
     * @return 用户名
     */
    @GetMapping("/info")
    public Response user(UserVo userVo) {
        UserInfoVo userInfo = userService.findUserInfo(userVo);
        return Response.success(userInfo);
    }

    /**
     * 通过ID查询当前用户信息
     *
     * @param id ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public UserVo user(@PathVariable Integer id) {
        return userService.selectUserVoById(id);
    }

    /**
     * 删除用户信息
     *
     * @param id ID
     * @return R
     */
    @DeleteMapping("/{id}")
    public Response userDel(@PathVariable Integer id) {
        SysUser sysUser = userService.selectById(id);
        if (CommonConstant.ADMIN_USER_NAME.equals(sysUser.getUsername())) {
            return Response.failure("不允许删除超级管理员");
        }
        return Response.success(userService.deleteUserById(sysUser));
    }

    /**
     * 添加用户
     *
     * @param userDto 用户信息
     * @return success/false
     */
    @PostMapping
    public Response user(@RequestBody UserInfoExtendVo userDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        sysUser.setDelFlag(CommonConstant.STATUS_NORMAL);
        sysUser.setPassword(ENCODER.encode(userDto.getNewpassword1()));
        userService.insert(sysUser);

        userDto.getRole().forEach(roleId -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(sysUser.getUserId());
            userRole.setRoleId(roleId);
            userRole.insert();
        });
        return Response.success(Boolean.TRUE);
    }

    /**
     * 更新用户信息
     *
     * @param userDto 用户信息
     * @return R
     */
    @PutMapping
    public Response userUpdate(@RequestBody UserInfoExtendVo userDto) {
        SysUser user = userService.selectById(userDto.getUserId());
        return Response.success(userService.updateUser(userDto, user.getUsername()));
    }

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @GetMapping("/findUserByUsername/{username}")
    public UserVo findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    /**
     * 通过手机号查询用户及其角色信息
     *
     * @param mobile 手机号
     * @return UseVo 对象
     */
    @GetMapping("/findUserByMobile/{mobile}")
    public UserVo findUserByMobile(@PathVariable String mobile) {
        return userService.findUserByMobile(mobile);
    }

    /**
     * 通过OpenId查询
     *
     * @param openId openid
     * @return 对象
     */
    @GetMapping("/findUserByOpenId/{openId}")
    public UserVo findUserByOpenId(@PathVariable String openId) {
        return userService.findUserByOpenId(openId);
    }

    /**
     * 分页查询用户
     *
     * @param params 参数集
     * @param userVO 用户信息
     * @return 用户集合
     */
    @GetMapping("/userPage")
    public Page userPage(@RequestParam Map<String, Object> params, UserVo userVO) {
        return userService.selectWithRolePage(new Query(params), userVO);
    }

    /**
     * 修改个人信息
     *
     * @param userDto userDto
     * @param userVo  登录用户信息
     * @return success/false
     */
    @PutMapping("/editInfo")
    public Response editInfo(@RequestBody UserInfoExtendVo userDto, UserVo userVo) {
        return userService.updateUserInfo(userDto, userVo.getUsername());
    }
}
