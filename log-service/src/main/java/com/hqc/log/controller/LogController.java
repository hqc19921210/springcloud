package com.hqc.log.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2021/5/30.
 */
@RestController
@RequestMapping("/log/api")

public class LogController {
    private Logger logger = LoggerFactory.getLogger(LogController.class);
    private static int errorCount =1;

    @RequestMapping("/audit/{productionId}/{num}")
    @SentinelResource(value = "block",blockHandler = "blockHandler1")
    public String audit(@PathVariable String productionId , @PathVariable int num){
        logger.info("审计记录成功，productionId：{}，num:{}",productionId,num);
        return "success";
    }

    public String blockHandler1(String productionId, int num , BlockException e){
        logger.error(String.format("audit被限流了！productionId：%s，num: %s",productionId,num),e);
        return "audit block handler";
    }

    @Value("${audit:false}")
    private boolean audit;
    /**
     * using nacos config manage properties
     * 限流测试
     *
     * @return
     */
    @RequestMapping("/auditConfig")
    @SentinelResource(value = "block",blockHandler = "blockHandler2")
    public String getConfig() {
        return String.valueOf(audit);
    }

    public String blockHandler2(BlockException e){
        logger.error("auditConfig被限流了！",e);
        return "auditConfig block";
    }

    /**
     * 熔断测试
     * @return
     * @throws Exception
     */
    @RequestMapping("/testSentinel")
    @SentinelResource(value = "block",fallback = "fallback")
    public String testSentinel() throws Exception {
        if((errorCount++)%2 == 0){
            throw new Exception("block");
        }
        return "success";
    }


    public String fallback(){
        logger.error("testSentinel被熔断！");
        return "testSentinel fallback";
    }
}
