package com.hqc.order.feign.fallback;

import com.hqc.order.feign.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/** FeignClient
 *          value : 微服务的应用服务名称
 *          fallback : 回调
 * Created by Administrator on 2021/6/1.
 */
@Component
public class LogServiceFallback implements LogService{
    private Logger logger = LoggerFactory.getLogger(LogServiceFallback.class);


    @Override
    public String auditLog(@PathVariable("productionId") String productionId, @PathVariable("num") int num) {
        logger.error("审计记录失败，productionId：{}，num:{}",productionId,num);
        return "fail";
    }
}
