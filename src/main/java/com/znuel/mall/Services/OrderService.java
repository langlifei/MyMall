package com.znuel.mall.Services;

import com.github.pagehelper.PageInfo;
import com.znuel.mall.Entities.Order;
import com.znuel.mall.Vo.OrderContent;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrderService {

    public int increaseOrder(Order order, HttpServletRequest request);

    public int getOrderId(String sn);

    public void insertProductToOrderItem(Integer orderId, HttpServletRequest request);

    public PageInfo<OrderContent> getOrderContent(Integer pageNum, String username);
}
