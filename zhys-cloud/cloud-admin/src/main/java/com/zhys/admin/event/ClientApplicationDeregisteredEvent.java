package com.zhys.admin.event;

import com.zhys.admin.model.Instance;

/**
 * 服务从admin删除
 * @Author: diandian
 * @date: 17:48 2019/5/9
 */
public class ClientApplicationDeregisteredEvent extends ClientApplicationEvent {
	private static final long serialVersionUID = 1L;

	public ClientApplicationDeregisteredEvent(String serviceId, Instance instance) {
		super(serviceId, instance, "DEREGISTRATION");
	}
}
