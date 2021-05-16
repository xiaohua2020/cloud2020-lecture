package com.atguigu.springcloud.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
