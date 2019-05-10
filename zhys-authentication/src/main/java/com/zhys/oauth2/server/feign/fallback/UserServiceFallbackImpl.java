package com.zhys.oauth2.server.feign.fallback;

import com.zhys.common.vo.UserVo;
import com.zhys.oauth2.server.feign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户服务的fallback
 * @Author: diandian
 * @date: 16:46 2019/5/9
 */
@Service
@Slf4j
public class UserServiceFallbackImpl implements UserService {

    @Override
    public UserVo findUserByUsername(String username) {
        log.error("通过用户名查询用户异常:{}", username);
        return new UserVo();
    }

    /**
     * 通过手机号查询用户、角色信息
     *
     * @param mobile 手机号
     * @return UserVo
     */
    @Override
    public UserVo findUserByMobile(String mobile) {
        log.error("通过手机号查询用户:{}", mobile);
        return new UserVo();
    }

    /**
     * 根据OpenId查询用户信息
     *
     * @param openId openId
     * @return UserVo
     */
    @Override
    public UserVo findUserByOpenId(String openId) {
        log.error("通过OpenId查询用户:{}", openId);
        return new UserVo();
    }
}
