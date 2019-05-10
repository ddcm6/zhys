package com.zhys.admin.converter;

import com.zhys.admin.model.Application;
import com.zhys.admin.model.Instance;
import org.springframework.cloud.client.ServiceInstance;

import java.util.Collection;

/**
 * 转换 {@link ServiceInstance}s to {@link Application}s.
 * @Author: diandian
 * @date: 14:03 2019/5/9
 */
public interface ServiceInstanceConverter {

    /**
     * 转换 {@link ServiceInstance}s to {@link Application}
     * @Author: diandian
     * @date: 14:03 2019/5/9
     */
    Collection<Instance> convert(String serviceId, Collection<ServiceInstance> instances);
}
