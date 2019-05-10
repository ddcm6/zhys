package com.zhys.admin.web.client;

import com.zhys.admin.model.Instance;
import org.springframework.http.HttpHeaders;

/**
 * 根据application获取指定header
 * @Author: diandian
 * @date: 17:46 2019/5/9
 */
public interface HttpHeadersProvider {

    /**
     * 读取实例所需Header
     *
     * @param instance 实例
     * @return HttpHeaders
     */
    HttpHeaders getHeaders(Instance instance);

}
