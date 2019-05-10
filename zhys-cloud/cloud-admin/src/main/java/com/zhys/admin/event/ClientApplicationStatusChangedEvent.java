package com.zhys.admin.event;

import com.zhys.admin.model.Instance;
import com.zhys.admin.model.StatusInfo;

/**
 * 服务状态变更事件
 * @Author: diandian
 * @date: 14:08 2019/5/9
 */
public class ClientApplicationStatusChangedEvent extends ClientApplicationEvent {
    private static final long serialVersionUID = 1L;
    private final StatusInfo from;
    private final StatusInfo to;

    public ClientApplicationStatusChangedEvent(String serviceId,
                                               Instance instance,
                                               StatusInfo from,
                                               StatusInfo to) {
        super(serviceId, instance, "STATUS_CHANGE");
        this.from = from;
        this.to = to;
    }

    public StatusInfo getFrom() {
        return from;
    }

    public StatusInfo getTo() {
        return to;
    }
}
