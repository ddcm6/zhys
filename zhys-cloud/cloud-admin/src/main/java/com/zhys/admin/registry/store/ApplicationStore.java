/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhys.admin.registry.store;


import com.zhys.admin.model.Application;
import com.zhys.admin.model.Instance;
import com.zhys.admin.model.StatusInfo;

import java.util.Collection;

/**
 * 服务缓存接口
 * @Author: diandian
 * @date: 14:03 2019/5/9
 */
public interface ApplicationStore {

    /**
     * 缓存服务实例
     * @Author: diandian
     * @date: 14:04 2019/5/9
     */
    void save(String serviceId, Instance instance);

    /**
     * 返回所有服务列表,包括down掉的服务
     * @Author: diandian
     * @date: 14:04 2019/5/9
     */
    Collection<Application> findAll();

    /**
     * 查询实例详情
     * @Author: diandian
     * @date: 14:04 2019/5/9
     */
    Instance find(String instanceId);

    /**
     * 根据实例id 删除服务, 也要在downmap中找
     * @Author: diandian
     * @date: 14:04 2019/5/9
     */
    void delete(String instanceId);

    /**
     * 服务实例状态变更
     * @Author: diandian
     * @date: 14:04 2019/5/9
     */
    void statusChange(String serviceId, String instanceId, StatusInfo from, StatusInfo to);
}
