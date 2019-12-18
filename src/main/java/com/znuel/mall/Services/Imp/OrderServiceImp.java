package com.znuel.mall.Services.Imp;

import com.znuel.mall.Dao.OrderItemMapper;
import com.znuel.mall.Dao.OrderMapper;
import com.znuel.mall.Entities.Order;
import com.znuel.mall.Entities.OrderItem;
import com.znuel.mall.Entities.Product;
import com.znuel.mall.Entities.User;
import com.znuel.mall.Services.OrderService;
import com.znuel.mall.Vo.CheckOutContent;
import com.znuel.mall.Vo.CheckOutItem;
import com.znuel.mall.Vo.OrderContent;
import com.znuel.mall.Vo.OrderContentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public int increaseOrder(Order order, HttpServletRequest request) {
        //获取用户信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        order.setUsername(user.getUsername());
        Date date = new Date();
        order.setCreate_time(date);
        order.setOrder_status(1);
        order.setDelivery_company("顺丰快递");
        //生成唯一标识符
        String id= UUID.randomUUID().toString();
        id=id.replace("-", "");//替换掉中间的那个斜杠
        order.setDelivery_sn(id);
        CheckOutContent checkOutContent = user.getCheckOutContent();
        order.setPromotion_amount(checkOutContent.getAmount());
        return orderMapper.insertSelective(order);
    }

    @Override
    public int getOrderId(String sn) {
        return orderMapper.selectOrderIdBySn(sn);
    }

    @Override
    public void insertProductToOrderItem(Integer orderId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<OrderItem> oItems = new ArrayList<>();
        List<CheckOutItem> checkOutItems = user.getCheckOutContent().getItems();
        for (CheckOutItem item : checkOutItems) {
            OrderItem oItem = new OrderItem();
            oItem.setOID(orderId);
            oItem.setPID(item.getpId());
            oItem.setProduct_attr("");
            oItem.setProductNumber(item.getQuantity());
            oItem.setProductTotalAmount(item.getTotalAmount());
            oItems.add(oItem);
        }
        orderItemMapper.insertItemBatch(oItems);
    }

    @Override
    public OrderContentList getOrderContent(String username) {
        //按时间倒序获取该用户的所有订单
        List<Order> orders = orderMapper.getOrders(username);
        List<OrderContent> orderContentList = new ArrayList<>();
        //根据每个订单的编号搜索所有购买商品
        for(int i = 0 ; i < orders.size();i++){
            OrderContent orderContent = new OrderContent();
            orderContent.setOrder(orders.get(i));
            List<Product> products = orderMapper.getProducts(orders.get(i).getOID());
            orderContent.setProducts(products);
            orderContentList.add(orderContent);
        }
        OrderContentList orderContentList1 = new OrderContentList();
        orderContentList1.setOrderContentList(orderContentList);
        return orderContentList1;
    }
}
