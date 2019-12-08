package com.znuel.mall.Controller;

import com.znuel.mall.Entities.Cart;
import com.znuel.mall.Entities.User;
import com.znuel.mall.Services.CartService;
import com.znuel.mall.Vo.CartContent;
import com.znuel.mall.Vo.CheckOutContent;
import com.znuel.mall.Vo.CheckOutItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
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
        User user = (User)session.getAttribute("user");
        cart.setUID(user.getID());
        Map<String,String> map = new HashMap<>();
        if(cartService.addProductToCart(cart)){
            map.put("info","添加成功!");
            user.setCartCount(user.getCartCount()+1);
            map.put("cartCount",user.getCartCount()+"");
        }else
            map.put("info","添加失败!");
        return map;
    }

    @RequestMapping(value = "/getCart.do",method = RequestMethod.GET)
    public String getCart(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //获取购物车中的商品
        List<CartContent> cartContents= cartService.queryCart(user.getID());
        model.addAttribute("cartContents",cartContents);
        //计算购物车中的商品总金额
        double amount = cartService.computeAmount(cartContents);
        model.addAttribute("amount",amount);
        return "cart";
    }

    @RequestMapping(value = "/delProductFromCart.do",method = RequestMethod.GET)
    public String removeProduct(Integer id,HttpServletRequest request){
        if(cartService.removeProduct(id))
        {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            user.setCartCount(user.getCartCount()-1);
        }
        return "forward:/getCart.do";
    }

    //提交购物车商品去结账
    @RequestMapping(value = "/checkOut.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> toCheckOut(String params,HttpServletRequest request){
        CheckOutContent checkOutContent = cartService.toCheckOut(params);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setCheckOutContent(checkOutContent);
        Map<String,String > map = new HashMap<>();
        map.put("info","添加结账信息成功!");
        return map;
    }
}
