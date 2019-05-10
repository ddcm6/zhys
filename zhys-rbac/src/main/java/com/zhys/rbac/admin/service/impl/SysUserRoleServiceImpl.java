package com.zhys.rbac.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhys.rbac.admin.dao.SysUserRoleDao;
import com.zhys.rbac.admin.po.SysUserRole;
import com.zhys.rbac.admin.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色表 服务实现类
 * @Author: diandian
 * @date: 9:19 2019/5/10
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {

    /**
     * 根据用户Id删除该用户的角色关系
     * @Author: diandian
     * @date: 9:20 2019/5/10
     */
    @Override
    public Boolean deleteByUserId(Integer userId) {
        return baseMapper.deleteByUserId(userId);
    }
}
