package com.zhys.rbac.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhys.common.constants.CommonConstant;
import com.zhys.common.utils.Query;
import com.zhys.common.web.BaseController;
import com.zhys.common.web.Response;
import com.zhys.rbac.admin.po.SysDict;
import com.zhys.rbac.admin.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 字典表 前端控制器
 * @Author: diandian
 * @date: 9:07 2019/5/10
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
    @Autowired
    private SysDictService sysDictService;

    /**
     * 通过ID查询字典信息
     *
     * @param id ID
     * @return 字典信息
     */
    @GetMapping("/{id}")
    public SysDict dict(@PathVariable Integer id) {
        return sysDictService.selectById(id);
    }

    /**
     * 分页查询字典信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @GetMapping("/dictPage")
    public Page dictPage(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return sysDictService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 通过字典类型查找字典
     *
     * @param type 类型
     * @return 同类型字典
     */
    @GetMapping("/type/{type}")
    public List<SysDict> findDictByType(@PathVariable String type) {
        SysDict condition = new SysDict();
        condition.setDelFlag(CommonConstant.STATUS_NORMAL);
        condition.setType(type);
        return sysDictService.selectList(new EntityWrapper<>(condition));
    }

    /**
     * 添加字典
     *
     * @param sysDict 字典信息
     * @return success、false
     */
    @PostMapping
    public Response dict(@RequestBody SysDict sysDict) {
        return Response.success(sysDictService.insert(sysDict));
    }

    /**
     * 删除字典，并且清除字典缓存
     *
     * @param id   ID
     * @param type 类型
     * @return R
     */
    @DeleteMapping("/{id}/{type}")
    public Response deleteDict(@PathVariable Integer id, @PathVariable String type) {
        return Response.success(sysDictService.deleteById(id));
    }

    /**
     * 修改字典
     *
     * @param sysDict 字典信息
     * @return success/false
     */
    @PutMapping
    public Response editDict(@RequestBody SysDict sysDict) {
        return Response.success(sysDictService.updateById(sysDict));
    }
}
