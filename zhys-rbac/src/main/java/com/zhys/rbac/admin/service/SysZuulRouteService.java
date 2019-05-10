package com.zhys.rbac.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhys.common.entity.SysZuulRoute;

/**
 * 动态路由配置表 服务类
 * @Author: diandian
 * @date: 14:31 2019/5/9
 */
public interface SysZuulRouteService extends IService<SysZuulRoute> {

    /**
     * 立即生效配置
     * @Author: diandian
     * @date: 14:31 2019/5/9
     */
    Boolean applyZuulRoute();
}
