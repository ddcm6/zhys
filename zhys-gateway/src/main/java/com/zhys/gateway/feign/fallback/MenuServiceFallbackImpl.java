package com.zhys.gateway.feign.fallback;

import com.xiaoleilu.hutool.collection.CollUtil;
import com.zhys.common.vo.MenuVo;
import com.zhys.gateway.feign.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class MenuServiceFallbackImpl implements MenuService {
    @Override
    public Set<MenuVo> findMenuByRole(String role) {
        log.error("调用{}异常{}", "findMenuByRole", role);
        return CollUtil.newHashSet();
    }
}
