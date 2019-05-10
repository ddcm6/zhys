package com.zhys.admin.converter;

import com.netflix.appinfo.InstanceInfo;
import com.zhys.admin.model.Instance;
import com.zhys.admin.model.LeaseInfo;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * ServiceInstanceConverter 实现
 * @Author: diandian
 * @date: 17:49 2019/5/9
 */
public class DefaultServiceInstanceConverter implements ServiceInstanceConverter {

    @Override
    public Collection<Instance> convert(String serviceId, Collection<ServiceInstance> instances) {
        return instances
                .stream()
                .map(instance -> {
                    if (instance instanceof EurekaDiscoveryClient.EurekaServiceInstance) {
                        final EurekaDiscoveryClient.EurekaServiceInstance eurekaServiceInstance = (EurekaDiscoveryClient
                                .EurekaServiceInstance) instance;
                        final InstanceInfo instanceInfo = eurekaServiceInstance.getInstanceInfo();
                        return createInstance(instanceInfo);
                    }
                    return null;
                }).collect(Collectors.toList());
    }

    /**
     * {@link InstanceInfo} 转 {@link Instance}
     *
     * @param instanceInfo InstanceInfo
     * @return Instance
     */
    private Instance createInstance(InstanceInfo instanceInfo) {
        final Instance instance = new Instance();
        instance.setInstanceId(instanceInfo.getInstanceId());
        instance.setHostName(instanceInfo.getHostName());
        instance.setAppName(instanceInfo.getAppName());
        instance.setIpAddr(instanceInfo.getIPAddr());
        instance.setStatus(instanceInfo.getStatus().name());
        instance.setOverriddenstatus(instanceInfo.getOverriddenStatus().name());
        instance.setPort(instanceInfo.getPort());
        instance.setSecurePort(instanceInfo.getSecurePort());
        instance.setMetadata(instanceInfo.getMetadata());
        instance.setHomePageUrl(instanceInfo.getHomePageUrl());
        instance.setStatusPageUrl(instanceInfo.getStatusPageUrl());
        instance.setHealthCheckUrl(instanceInfo.getHealthCheckUrl());
        instance.setVipAddress(instanceInfo.getVIPAddress());
        instance.setSecureVipAddress(instanceInfo.getSecureVipAddress());
        instance.setCoordinatingDiscoveryServer(instanceInfo.isCoordinatingDiscoveryServer());
        instance.setLastUpdatedTime(new Date(instanceInfo.getLastUpdatedTimestamp()));
        instance.setLastDirtyTime(new Date(instanceInfo.getLastDirtyTimestamp()));
        instance.setActionType(instanceInfo.getActionType().name());
        final LeaseInfo leaseInfo = new LeaseInfo();
        leaseInfo.setRenewalIntervalInSecs(instanceInfo.getLeaseInfo().getRenewalIntervalInSecs());
        leaseInfo.setDurationInSecs(instanceInfo.getLeaseInfo().getDurationInSecs());
        leaseInfo.setRegistrationTime(new Date(instanceInfo.getLeaseInfo().getRegistrationTimestamp()));
        leaseInfo.setLastRenewalTime(new Date(instanceInfo.getLeaseInfo().getRenewalTimestamp()));
        leaseInfo.setEvictionTime(new Date(instanceInfo.getLeaseInfo().getEvictionTimestamp()));
        leaseInfo.setServiceUpTime(new Date(instanceInfo.getLeaseInfo().getServiceUpTimestamp()));

        instance.setLeaseInfo(leaseInfo);
        return instance;
    }
}
