package com.znuel.mall.Controller;

import com.znuel.mall.Entities.Cart;
import com.znuel.mall.Entities.User;
import com.znuel.mall.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;


    @RequestMapping(value = "/addProduct.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addProduct(@RequestBody Cart cart, HttpServletRequest request){
        //获取用户ID
        HttpSession session = request.getSession();
        int PID = (Integer) request.getAttribute("PID");
        cart.setPID(PID);
        User user = (User)session.getAttribute("user");
        cart.setUID(user.getID());
        Map<String,String> map = new HashMap<>();
        if(cartService.addProductToCart(cart)){
            map.put("info","添加成功!");
        }else
            map.put("info","添加失败!");
        return map;
    }
}
