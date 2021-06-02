package com.hqc.stock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2021/5/30.
 */
@RestController
@RequestMapping("/stock/api")
public class StockController {
    private Logger logger = LoggerFactory.getLogger(StockController.class);


    @RequestMapping("/reduce/{productionId}/{num}")
    public String reduce(@PathVariable String productionId , @PathVariable int num){
        logger.info("扣减{}商品ID为{}的库存成功",num,productionId);
        return "success";
    }
}
