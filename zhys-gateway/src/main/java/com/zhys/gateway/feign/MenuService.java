package com.zhys.gateway.feign;

import com.zhys.common.constants.ServiceNameConstants;
import com.zhys.common.vo.MenuVo;
import com.zhys.gateway.feign.fallback.MenuServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = ServiceNameConstants.RBAC_SERVICE, fallback = MenuServiceFallbackImpl.class)
public interface MenuService {
    /**
     * 通过角色名查询菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    @GetMapping(value = "/menu/findMenuByRole/{role}")
    Set<MenuVo> findMenuByRole(@PathVariable("role") String role);
}
