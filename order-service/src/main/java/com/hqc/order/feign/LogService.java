package com.hqc.order.feign;

import com.hqc.order.feign.fallback.LogServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2021/6/1.
 */
@FeignClient(value = "log-service" , fallback = LogServiceFallback.class)
public interface LogService {

    @RequestMapping("/log/api/audit/{productionId}/{num}")
    String auditLog(@PathVariable("productionId") String productionId, @PathVariable("num") int num);
}
