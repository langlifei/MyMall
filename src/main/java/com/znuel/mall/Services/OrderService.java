package com.znuel.mall.Services;

import com.znuel.mall.Entities.Order;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {

    public int increaseOrder(Order order, HttpServletRequest request);

    public int getOrderId(String sn);

    public void insertProductToOrderItem(Integer orderId,HttpServletRequest request);
}
