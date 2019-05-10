package com.zhys.rbac.admin.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.zhys.rbac.admin.po.SysDept;
import com.zhys.rbac.admin.vo.DeptTreeVo;

import java.util.List;

/**
 * 部门管理 服务类
 * @Author: diandian
 * @date: 14:31 2019/5/9
 */
public interface SysDeptService extends IService<SysDept> {

    /**
     * 查询部门树菜单
     * @Author: diandian
     * @date: 14:32 2019/5/9
     */
    List<DeptTreeVo> selectListTree(EntityWrapper<SysDept> sysDeptEntityWrapper);

    /**
     * 添加信息部门
     * @Author: diandian
     * @date: 14:32 2019/5/9
     */
    Boolean insertDept(SysDept sysDept);

    /**
     * 删除部门
     * @Author: diandian
     * @date: 14:32 2019/5/9
     */
    Boolean deleteDeptById(Integer id);

    /**
     * 更新部门
     * @Author: diandian
     * @date: 14:32 2019/5/9
     */
    Boolean updateDeptById(SysDept sysDept);
}
