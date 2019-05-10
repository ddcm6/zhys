package com.zhys.rbac.admin.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNodeVo {
    protected int id;
    protected int parentId;
    protected List<TreeNodeVo> children = new ArrayList<TreeNodeVo>();

    public void add(TreeNodeVo node) {
        children.add(node);
    }
}
