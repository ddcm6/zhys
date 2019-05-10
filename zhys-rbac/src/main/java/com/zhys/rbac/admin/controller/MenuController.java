package com.zhys.rbac.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhys.common.constants.CommonConstant;
import com.zhys.common.constants.SecurityConstants;
import com.zhys.common.vo.MenuVo;
import com.zhys.common.web.BaseController;
import com.zhys.common.web.Response;
import com.zhys.rbac.admin.common.util.TreeUtil;
import com.zhys.rbac.admin.po.SysMenu;
import com.zhys.rbac.admin.service.SysMenuService;
import com.zhys.rbac.admin.vo.MenuTreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 通过角色名称查询用户菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    @GetMapping("/findMenuByRole/{role}")
    public List<MenuVo> findMenuByRole(@PathVariable String role) {
        return sysMenuService.findMenuByRoleName(role);
    }

    /**
     * 返回当前用户的树形菜单集合
     *
     * @return 当前用户的树形菜单
     */
    @GetMapping(value = "/userMenu")
    public List<MenuTreeVo> userMenu(@RequestHeader(name = SecurityConstants.ROLE_HEADER) String roles) {
        if (StringUtils.isEmpty(roles)) {
            return Collections.emptyList();
        }
        // 获取符合条件得菜单
        Set<MenuVo> all = new HashSet<>();
        Arrays.stream(roles.split(",")).forEach(role -> all.addAll(sysMenuService.findMenuByRoleName(role)));
        List<MenuTreeVo> menuTreeList = new ArrayList<>();
        all.forEach(menuVo -> {
            if (CommonConstant.MENU.equals(menuVo.getType())) {
                menuTreeList.add(new MenuTreeVo(menuVo));
            }
        });
        menuTreeList.sort(Comparator.comparing(MenuTreeVo::getSort));
        return TreeUtil.bulid(menuTreeList, -1);
    }

    /**
     * 返回树形菜单集合
     *
     * @return 树形菜单
     */
    @GetMapping(value = "/allTree")
    public List<MenuTreeVo> getTree() {
        SysMenu condition = new SysMenu();
        condition.setDelFlag(CommonConstant.STATUS_NORMAL);
        return TreeUtil.bulidTree(sysMenuService.selectList(new EntityWrapper<>(condition)), -1);
    }

    /**
     * 返回角色的菜单集合
     *
     * @param roleName 角色名称
     * @return 属性集合
     */
    @GetMapping("/roleTree/{roleName}")
    public List<Integer> roleTree(@PathVariable String roleName) {
        List<MenuVo> menus = sysMenuService.findMenuByRoleName(roleName);
        List<Integer> menuList = new ArrayList<>();
        for (MenuVo menuVo : menus) {
            menuList.add(menuVo.getMenuId());
        }
        return menuList;
    }

    /**
     * 通过ID查询菜单的详细信息
     *
     * @param id 菜单ID
     * @return 菜单详细信息
     */
    @GetMapping("/{id}")
    public SysMenu menu(@PathVariable Integer id) {
        return sysMenuService.selectById(id);
    }

    /**
     * 新增菜单
     *
     * @param sysMenu 菜单信息
     * @return success/false
     */
    @PostMapping
    public Response menu(@RequestBody SysMenu sysMenu) {
        return Response.success(sysMenuService.insert(sysMenu));
    }

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return success/false
     * TODO  级联删除下级节点
     */
    @DeleteMapping("/{id}")
    public Response menuDel(@PathVariable Integer id) {
        return Response.success(sysMenuService.deleteMenu(id));
    }

    @PutMapping
    public Response menuUpdate(@RequestBody SysMenu sysMenu) {
        return Response.success(sysMenuService.updateMenuById(sysMenu));
    }

}
