package com.zhys.rbac.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhys.common.constants.CommonConstant;
import com.zhys.common.entity.SysZuulRoute;
import com.zhys.common.utils.Query;
import com.zhys.common.web.BaseController;
import com.zhys.common.web.Response;
import com.zhys.rbac.admin.service.SysZuulRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * 动态路由配置表 前端控制器
 * @Author: diandian
 * @date: 9:14 2019/5/10
 */
@RestController
@RequestMapping("/route")
public class ZuulRouteController extends BaseController {
    @Autowired
    private SysZuulRouteService sysZuulRouteService;
    /**
     * 通过ID查询
     *
     * @param id ID
     * @return SysZuulRoute
     */
    @GetMapping("/{id}")
    public SysZuulRoute get(@PathVariable Integer id) {
        return sysZuulRouteService.selectById(id);
    }

    /**
     * 分页查询信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public Page page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return sysZuulRouteService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     *
     * @param sysZuulRoute 实体
     * @return success/false
     */
    @PostMapping
    public Response add(@RequestBody SysZuulRoute sysZuulRoute) {
        return Response.success(sysZuulRouteService.insert(sysZuulRoute));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        SysZuulRoute sysZuulRoute = new SysZuulRoute();
        sysZuulRoute.setId(id);
        sysZuulRoute.setUpdateTime(new Date());
        sysZuulRoute.setDelFlag(CommonConstant.STATUS_DEL);
        return Response.success(sysZuulRouteService.updateById(sysZuulRoute));
    }

    /**
     * 编辑
     *
     * @param sysZuulRoute 实体
     * @return success/false
     */
    @PutMapping
    public Response edit(@RequestBody SysZuulRoute sysZuulRoute) {
        sysZuulRoute.setUpdateTime(new Date());
        return Response.success(sysZuulRouteService.updateById(sysZuulRoute));
    }

    /**
     * 刷新配置
     *
     * @return success/fasle
     */
    @GetMapping("/apply")
    public Response apply() {
        return Response.success(sysZuulRouteService.applyZuulRoute());
    }
}
