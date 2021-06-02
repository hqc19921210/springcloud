package com.hqc.order.feign;

import com.hqc.order.feign.fallback.StockServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** FeignClient
 *          value : 微服务的应用服务名称
 *          fallback : 回调
 * Created by Administrator on 2021/6/1.
 */
@FeignClient(value = "stock-service" , fallback = StockServiceFallback.class)
public interface StockService {

    @RequestMapping("/stock/api/reduce/{productionId}/{num}")
    public String reduce(@PathVariable("productionId") String productionId, @PathVariable("num") int num);
}
