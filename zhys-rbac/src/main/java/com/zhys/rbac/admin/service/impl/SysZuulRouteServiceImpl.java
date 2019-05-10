package com.zhys.rbac.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhys.common.constants.CommonConstant;
import com.zhys.common.entity.SysZuulRoute;
import com.zhys.common.redis.template.ZhysRedisRepository;
import com.zhys.common.utils.JsonUtils;
import com.zhys.rbac.admin.dao.SysZuulRouteDao;
import com.zhys.rbac.admin.service.SysZuulRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 动态路由配置表 服务实现类
 * @Author: diandian
 * @date: 9:30 2019/5/10
 */
@Service
public class SysZuulRouteServiceImpl extends ServiceImpl<SysZuulRouteDao, SysZuulRoute> implements SysZuulRouteService {

    @Autowired
    private ZhysRedisRepository redisRepository;

    /**
     * 同步路由配置信息,到服务网关
     *
     * @return 同步成功
     */
    @Override
    public Boolean applyZuulRoute() {
        EntityWrapper<SysZuulRoute> wrapper = new EntityWrapper<>();
        wrapper.eq(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        List<SysZuulRoute> routeList = selectList(wrapper);
        redisRepository.set(CommonConstant.ROUTE_KEY, JsonUtils.toJsonString(routeList));
        return Boolean.TRUE;
    }
}
