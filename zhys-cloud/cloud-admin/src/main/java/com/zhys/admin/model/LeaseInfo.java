package com.zhys.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhys.common.constants.CommonConstant;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务注册信息
 * @Author: diandian
 * @date: 17:46 2019/5/9
 */
@Data
public class LeaseInfo implements Serializable {

    private static final long serialVersionUID = -1098405211937231715L;

    /**
     * 续约更新时间间隔
     */
    private int renewalIntervalInSecs ;
    /**
     * 续约到期时间
     */
    private int durationInSecs;

    /**
     *  注册时间
     */
    @JsonFormat(pattern = CommonConstant.DATETIME_FORMAT, timezone = "GMT+8")
    private Date registrationTime;
    /**
     * 最后续约时间
     */
    @JsonFormat(pattern = CommonConstant.DATETIME_FORMAT, timezone = "GMT+8")
    private Date lastRenewalTime;
    /**
     * 剔除时间
     */
    @JsonFormat(pattern = CommonConstant.DATETIME_FORMAT, timezone = "GMT+8")
    private Date evictionTime;
    /**
     * 服务上线时间
     */
    @JsonFormat(pattern = CommonConstant.DATETIME_FORMAT, timezone = "GMT+8")
    private Date serviceUpTime;
}
