package com.znuel.mall.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.znuel.mall.Entities.Order;
import com.znuel.mall.Entities.User;
import com.znuel.mall.Services.CartService;
import com.znuel.mall.Services.OrderService;
import com.znuel.mall.Vo.OrderContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/placeOrder.do", method = RequestMethod.POST)
    public String checkOut(Order order, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (orderService.increaseOrder(order, request) > 0) {
            Integer oId = orderService.getOrderId(order.getDelivery_sn());
            if (oId != 0 && oId != null) {
                //添加商品详细订单项
                orderService.insertProductToOrderItem(oId, request);
                //购买商品后移除购物车中购买的商品
                cartService.removeProductAfterPO(request);
                //更新购物车中商品的个数
                user.setCartCount(cartService.getCount(user.getID()));
                return "redirect:/getOrders.do";
            }
        }
        return "forward:/content.do";
    }

    @RequestMapping(value = "/getOrders.do", method = RequestMethod.GET)
    public String getOrders(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PageHelper.startPage(pageNum, 3, true);
        PageInfo<OrderContent> pageInfo = orderService.getOrderContent(pageNum, user.getUsername());
        model.addAttribute("pageInfo", pageInfo);
        return "order";
    }

}
