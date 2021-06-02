package com.hqc.order.controller;

import com.hqc.order.feign.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2021/5/30.
 */
@RestController
@RequestMapping("/demo/api")
//自动刷新配置中心的配置
@RefreshScope
public class DemoController {

    @Autowired
    @Qualifier(value = "usingUrl")
    private volatile RestTemplate urlRestTemplate;

    @Autowired
    @Qualifier(value = "usingRibbon")
    private RestTemplate ribbonRestTemplate;

    @Autowired
    private DemoService demoService;


    @GetMapping("/list")
    public String getList(){
        return "List";
    }

    @Value("${aaa:false}")
    private boolean aaa;
    /**
     * using nacos config manage properties
     * @return
     */
    @RequestMapping("/config")
    public String getConfig() {
        return String.valueOf(aaa);
    }

    /**
     *  using rest template with url
     * @param id
     * @return
     */
    @RequestMapping("/create1/{id}")
    public String callStock1(@PathVariable String id) {
        System.out.println("create1 : "+id);
        String url = "http://192.168.3.38:8082/stock/api/reduce";
        return urlRestTemplate.getForObject(url,String.class);

    }

    /**
     * using rest template with nacos service
     * @param id
     * @return
     */
    @RequestMapping("/create2/{id}")
    public String callStock2(@PathVariable String id) {
        System.out.println("create2 : "+id);
        String url = "http://stock-service/stock/api/reduce";
        return ribbonRestTemplate.getForObject(url,String.class);
    }

    /**
     * using feign service
     * @param id
     * @return
     */
    @RequestMapping("/create3/{id}")
    public String callStock3(@PathVariable String id) {
        System.out.println("create3 : "+id);
        return demoService.reduce();
    }


}
