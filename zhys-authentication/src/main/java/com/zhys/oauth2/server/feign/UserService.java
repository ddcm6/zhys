package com.zhys.oauth2.server.feign;

import com.zhys.common.constants.ServiceNameConstants;
import com.zhys.common.vo.UserVo;
import com.zhys.oauth2.server.feign.fallback.UserServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @Author: diandian
 * @date: 16:45 2019/5/9
 */
@FeignClient(name = ServiceNameConstants.RBAC_SERVICE, fallback = UserServiceFallbackImpl.class)
public interface UserService {
    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return UserVo
     */
    @GetMapping("/user/findUserByUsername/{username}")
    UserVo findUserByUsername(@PathVariable("username") String username);

    /**
     * 通过手机号查询用户、角色信息
     *
     * @param mobile 手机号
     * @return UserVo
     */
    @GetMapping("/user/findUserByMobile/{mobile}")
    UserVo findUserByMobile(@PathVariable("mobile") String mobile);

    /**
     * 根据OpenId查询用户信息
     * @param openId openId
     * @return UserVo
     */
    @GetMapping("/user/findUserByOpenId/{openId}")
    UserVo findUserByOpenId(@PathVariable("openId") String openId);
}
