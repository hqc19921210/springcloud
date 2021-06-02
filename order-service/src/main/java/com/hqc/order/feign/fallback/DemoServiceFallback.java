package com.hqc.order.feign.fallback;

import com.hqc.order.feign.DemoService;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2021/5/30.
 */
@Component
public class DemoServiceFallback implements DemoService {
    public String reduce() {
        System.out.println("stock reduce error");
        return "error";
    }
}
