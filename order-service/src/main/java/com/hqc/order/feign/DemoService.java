package com.hqc.order.feign;

import com.hqc.order.feign.fallback.DemoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created by Administrator on 2021/5/30.
 */
@FeignClient(value = "demo-service",fallback = DemoServiceFallback.class)  //在注册中心的服务名
public interface DemoService {

    @RequestMapping("/demo/api/xxx")
    String  reduce();
}
