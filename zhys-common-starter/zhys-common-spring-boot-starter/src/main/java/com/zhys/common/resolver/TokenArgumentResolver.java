package com.zhys.common.resolver;

import com.xiaoleilu.hutool.util.StrUtil;
import com.zhys.common.constants.SecurityConstants;
import com.zhys.common.vo.SysRoleVo;
import com.zhys.common.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Token转化UserVo
 * @Author: diandian
 * @date: 16:55 2019/5/9
 */
@Slf4j
public class TokenArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 1. 入参筛选
     *
     * @param methodParameter 参数集合
     * @return 格式化后的参数
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(UserVo.class);
    }

    /**
     * @param methodParameter       入参集合
     * @param modelAndViewContainer model 和 view
     * @param nativeWebRequest      web相关
     * @param webDataBinderFactory  入参解析
     * @return 包装对象
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String username = request.getHeader(SecurityConstants.USER_HEADER);
        String roles = request.getHeader(SecurityConstants.ROLE_HEADER);
        if (StrUtil.isBlank(username) || StrUtil.isBlank(roles)) {
            log.warn("resolveArgument error username or role is empty");
            return null;
        } else {
            log.info("resolveArgument username :{} roles:{}", username, roles);
        }
        UserVo userVO = new UserVo();
        userVO.setUsername(username);
        List<SysRoleVo> sysRoleList = new ArrayList<>();
        Arrays.stream(roles.split(",")).forEach(role -> {
            SysRoleVo sysRole = new SysRoleVo();
            sysRole.setRoleName(role);
            sysRoleList.add(sysRole);
        });
        userVO.setRoleList(sysRoleList);
        return userVO;
    }

}
