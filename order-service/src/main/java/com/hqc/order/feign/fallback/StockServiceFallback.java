package com.hqc.order.feign.fallback;

import com.hqc.order.feign.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2021/6/1.
 */
@Component
public class StockServiceFallback implements StockService{
    private Logger logger = LoggerFactory.getLogger(StockServiceFallback.class);

    @Override
    public String reduce(@PathVariable String productionId, @PathVariable int num) {
        logger.error("扣减{}商品ID为{}的库存失败",num,productionId);
        return "fail";
    }
}
