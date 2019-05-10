package com.zhys.rbac.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhys.rbac.admin.po.SysDept;

import java.util.List;

/**
 * 部门管理 Mapper 接口
 * @Author: diandian
 * @date: 14:24 2019/5/9
 */
public interface SysDeptDao extends BaseMapper<SysDept> {

    /**
     * 关联dept——relation
     * @Author: diandian
     * @date: 14:24 2019/5/9
     */
    List<SysDept> selectDeptDtoList(String delFlag);

    /**
     * 删除部门关系表数据
     * @Author: diandian
     * @date: 14:24 2019/5/9
     */
    void deleteDeptRealtion(Integer id);
}
