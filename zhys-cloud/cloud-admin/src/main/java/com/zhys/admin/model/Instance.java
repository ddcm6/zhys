package com.zhys.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhys.common.constants.CommonConstant;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/**
 * 服务实例对象
 * @Author: diandian
 * @date: 8:53 2019/5/10
 */
@Data
public class Instance implements Serializable {

    private static final long serialVersionUID = 1831251106828089980L;

    private String instanceId;

    private String hostName;

    private String appName;

    private String ipAddr;

    private String status;

    private String overriddenstatus;

    private int port;

    private int securePort;

    private Map<String, String> metadata = Collections.emptyMap();

    private String homePageUrl;

    private String statusPageUrl;

    private String healthCheckUrl;

    private String vipAddress;

    private String secureVipAddress;

    private boolean isCoordinatingDiscoveryServer;

    @JsonFormat(pattern = CommonConstant.DATETIME_FORMAT, timezone = "GMT+8")
    private Date lastUpdatedTime;

    @JsonFormat(pattern = CommonConstant.DATETIME_FORMAT, timezone = "GMT+8")
    private Date lastDirtyTime;

    private String actionType;

    private LeaseInfo leaseInfo;
}
