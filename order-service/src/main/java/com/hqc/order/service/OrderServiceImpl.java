package com.hqc.order.service;

import com.hqc.order.feign.LogService;
import com.hqc.order.feign.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2021/6/1.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private StockService stockService;
    @Autowired
    private LogService logService;

    @Override
    public String createOrder(String productionId, int num) {
        logger.info("下单{}个产品{}",num,productionId);
        stockService.reduce(productionId,num);
        logService.auditLog(productionId,num);
        return "success";
    }
}
