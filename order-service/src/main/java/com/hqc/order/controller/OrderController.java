package com.hqc.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2021/5/30.
 */
@RestController
@RequestMapping("/api/order")
@RefreshScope
public class OrderController {

    @GetMapping("/list")
    public String getList(){
        return "List";
    }


    @Value("${aaa:false}")
    private boolean aaa;

    @RequestMapping("/aaa")
    public String get() {
        return String.valueOf(aaa);
    }

}
