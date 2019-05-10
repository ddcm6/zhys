package com.zhys.rbac.admin.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门树
 * @Author: diandian
 * @date: 14:23 2019/5/9
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeptTreeVo extends TreeNodeVo {
    private String name;
}
