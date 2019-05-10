package com.zhys.admin.event;

import com.zhys.admin.model.Instance;

/**
 * 服务注册到admin
 * @Author: diandian
 * @date: 17:48 2019/5/9
 */
public class ClientApplicationRegisteredEvent extends ClientApplicationEvent {
	private static final long serialVersionUID = 1L;

	public ClientApplicationRegisteredEvent(String serviceId, Instance instance) {
		super(serviceId, instance, "REGISTRATION");
	}
}
