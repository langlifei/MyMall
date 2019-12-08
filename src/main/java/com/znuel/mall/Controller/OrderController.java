package com.znuel.mall.Controller;

import com.znuel.mall.Entities.Order;
import com.znuel.mall.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/placeOrder.do",method = RequestMethod.POST)
    public String checkOut(Order order, HttpServletRequest request){
        if(orderService.increaseOrder(order,request) > 0){
            Integer oId = orderService.getOrderId(order.getDelivery_sn());
            if(oId != 0 && oId != null){
                if(orderService.insertProductToOrderItem(oId,request))
                    return "forward:/getCart.do";
            }
        }
        return null;
    }
}
