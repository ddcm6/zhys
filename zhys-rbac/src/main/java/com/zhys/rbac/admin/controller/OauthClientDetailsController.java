package com.zhys.rbac.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhys.common.utils.Query;
import com.zhys.common.web.BaseController;
import com.zhys.common.web.Response;
import com.zhys.rbac.admin.po.SysOauthClientDetails;
import com.zhys.rbac.admin.service.SysOauthClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 前端控制器
 * @Author: diandian
 * @date: 9:10 2019/5/10
 */
@RestController
@RequestMapping("/client")
public class OauthClientDetailsController extends BaseController {

    @Autowired
    private SysOauthClientDetailsService sysOauthClientDetailsService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return SysOauthClientDetails
     */
    @GetMapping("/{id}")
    public SysOauthClientDetails get(@PathVariable Integer id) {
        return sysOauthClientDetailsService.selectById(id);
    }


    /**
     * 分页查询信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public Page page(@RequestParam Map<String, Object> params) {
        return sysOauthClientDetailsService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     *
     * @param client 实体
     * @return success/false
     */
    @PostMapping
    public Response add(@RequestBody SysOauthClientDetails client) {
        if (StringUtils.isEmpty(client.getAdditionalInformation())) {
            client.setAdditionalInformation(null);
        }
        final String secret = encoder.encode(client.getClientSecret());
        client.setClientSecret(secret);
        return Response.success(sysOauthClientDetailsService.insert(client));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable String id) {
        SysOauthClientDetails sysOauthClientDetails = new SysOauthClientDetails();
        sysOauthClientDetails.setClientId(id);
        return Response.success(sysOauthClientDetailsService.deleteById(sysOauthClientDetails));
    }

    /**
     * 编辑
     *
     * @param client 实体
     * @return success/false
     */
    @PutMapping
    public Response edit(@RequestBody SysOauthClientDetails client) {
        final String pass = client.getClientSecret();
        final SysOauthClientDetails details = sysOauthClientDetailsService.selectById(client.getClientId());
        if (encoder.matches(pass, details.getClientSecret())) {
            client.setClientSecret(encoder.encode(pass));
        }
        return Response.success(sysOauthClientDetailsService.updateById(client));
    }
}
