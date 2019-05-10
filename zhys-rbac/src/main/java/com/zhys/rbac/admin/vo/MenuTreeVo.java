package com.zhys.rbac.admin.vo;

import com.zhys.common.vo.MenuVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MenuTreeVo extends TreeNodeVo {
    private String icon;
    private String name;
    private String url;
    private boolean spread = false;
    private String path;
    private String component;
    private String authority;
    private String redirect;
    private String code;
    private String type;
    private String label;
    private Integer sort;

    public MenuTreeVo() {
    }

    public MenuTreeVo(int id, String name, int parentId) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.label = name;
    }

    public MenuTreeVo(int id, String name, MenuTreeVo parent) {
        this.id = id;
        this.parentId = parent.getId();
        this.name = name;
        this.label = name;
    }

    public MenuTreeVo(MenuVo menuVo) {
        this.id = menuVo.getMenuId();
        this.parentId = menuVo.getParentId();
        this.icon = menuVo.getIcon();
        this.name = menuVo.getName();
        this.url = menuVo.getUrl();
        this.path = menuVo.getPath();
        this.component = menuVo.getComponent();
        this.type = menuVo.getType();
        this.label = menuVo.getName();
        this.sort = menuVo.getSort();
    }
}
