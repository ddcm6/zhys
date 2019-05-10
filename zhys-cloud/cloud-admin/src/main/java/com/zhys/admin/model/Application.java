package com.zhys.admin.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 服务实体
 * @Author: diandian
 * @date: 8:53 2019/5/10
 */
@Data
public class Application implements Serializable {

    private static final long serialVersionUID = 6719219594944532374L;

    /**
     * 服务id
     */
    private String serviceId;

    /**
     * 服务实例集合
     */
    private Collection<Instance> instances = new ArrayList<>();
}
