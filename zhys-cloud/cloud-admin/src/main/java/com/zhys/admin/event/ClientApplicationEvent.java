package com.zhys.admin.event;

import com.zhys.admin.model.Instance;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClientApplicationEvent implements Serializable {

	private static final long serialVersionUID = -5376293152556637178L;
	private final String serviceId;
	private final Instance instance;

	private final long timestamp;
	private final String type;

	protected ClientApplicationEvent(String serviceId, Instance instance, String type) {
		this.serviceId = serviceId;
		this.instance = instance;
		this.timestamp = System.currentTimeMillis();
		this.type = type;
	}
}
