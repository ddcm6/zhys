package com.zhys.rbac.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhys.common.constants.CommonConstant;
import com.zhys.common.entity.SysLog;
import com.zhys.common.exception.ClientException;
import com.zhys.common.utils.Query;
import com.zhys.common.web.BaseController;
import com.zhys.common.web.Response;
import com.zhys.rbac.admin.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * 日志表 前端控制器
 * @Author: diandian
 * @date: 9:08 2019/5/10
 */
@RestController
@RequestMapping("/log")
public class LogController extends BaseController {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 分页查询日志信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @GetMapping("/logPage")
    public Page logPage(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return sysLogService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 根据ID
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        return Response.success(sysLogService.updateByLogId(id));
    }

    /**
     * 添加日志
     *
     * @param log 日志实体
     * @param result 错误信息
     */
    @PostMapping
    public void add(@Valid @RequestBody SysLog log, BindingResult result) {
        if (result.hasErrors()) {
            throw new ClientException(result.getAllErrors().get(0).getDefaultMessage());
        }
        sysLogService.insert(log);
    }
}
