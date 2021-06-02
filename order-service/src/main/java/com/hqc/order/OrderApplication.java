package com.hqc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2021/5/30.
 */
@SpringBootApplication
@EnableDiscoveryClient //让注册中心发现
@EnableFeignClients //使用Feign编写代码
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }


    //使用RestTemplate为例 @disable
    @Bean("usingUrl")
    public RestTemplate urlRestTemplate(){
        return new RestTemplate();
    }

    @Bean("usingRibbon")
    @LoadBalanced  //ribbon负载均衡
    public RestTemplate ribbonRestTemplate(){
        return new RestTemplate();
    }
}
