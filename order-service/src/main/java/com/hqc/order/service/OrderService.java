package com.hqc.order.service;

/**
 * Created by Administrator on 2021/6/1.
 */
public interface OrderService {
    /**
     * 创建订单
     * @param productionId 商品ID
     * @param num 数量
     * @return
     */
    String createOrder(String productionId,int num);
}
