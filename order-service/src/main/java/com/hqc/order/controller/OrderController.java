package com.hqc.order.controller;

import com.hqc.order.feign.LogService;
import com.hqc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2021/6/1.
 */
@RestController
@RequestMapping("/order/api")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @RequestMapping("/creation/{productionId}/{num}")
    public String order(@PathVariable String productionId ,@PathVariable int num){
        return orderService.createOrder(productionId, num);
    }



    @GetMapping("/list")
    public String getList(){
        return "list";
    }

}
