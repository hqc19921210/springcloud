package com.hqc.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Administrator on 2021/5/30.
 */
@SpringBootApplication
@EnableDiscoveryClient //让注册中心发现
@EnableFeignClients //使用Feign编写代码
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class,args);
    }
}
