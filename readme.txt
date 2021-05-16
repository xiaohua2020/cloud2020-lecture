1. 建模块
2. 改POM
3. 写YML
4. 主启动
5. 业务类

业务类：
1. 建表
2. entities
3. dao
4. service
5. controller

启动consul
1. cmd -> consul agent -dev
2. 地址栏访问http://localhost:8500

负载轮询算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标

List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

如：
List[0] = 127.0.0.1:8002
List[1] = 127.0.0.1:8001

8001 + 8002 组合为集群，它们共计2台机器，集群总数为2，按照轮询算法原理：
当前请求数为1时，1 % 2 = 1对应下标位置为1，则获得服务地址为127.0.0.1：8001
当前请求数为2时，2 % 2 = 0对应下标位置为0，则获得服务地址为127.0.0.1：8002
当前请求数为3时，3 % 2 = 1对应下标位置为1，则获得服务地址为127.0.0.1：8001
当前请求数为4时，4 % 2 = 0对应下标位置为0，则获得服务地址为127.0.0.1：8002
以此类推。。。


服务降级(fallback)
服务熔断(break)
服务限流(flowlimit)