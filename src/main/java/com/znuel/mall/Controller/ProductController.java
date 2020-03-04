package com.znuel.mall.Controller;

import com.znuel.mall.Entities.Cart;
import com.znuel.mall.Entities.Product;
import com.znuel.mall.Entities.User;
import com.znuel.mall.Services.CartService;
import com.znuel.mall.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/product.do", method = RequestMethod.GET)
    public String productDetail(Integer id, Model model) {
        Product product = productService.getDetailsById(id);
        model.addAttribute("productDetail", product);
        return "product";
    }

    @RequestMapping(value = "/addCompare.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addToCompare(@RequestBody Cart cart, HttpServletRequest request) {
        //获取用户ID
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Map<String, String> map = new HashMap<>();
        String info = "";
        if (productService.addToCompare(user, cart))
            info = "添加成功!";
        else
            info = "已达到最大比较数目,请删除后再比较!";
        map.put("info", info);
        return map;
    }

    //从比较中移除
    @RequestMapping(value = "/removeFromCompare.do", method = RequestMethod.GET)
    public String removeFromCompare(Integer index, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        productService.removeFromCompare(user, index);
        return "compare";
    }

    //将比较中的商品添加到购物车
    @RequestMapping(value = "/addToCartFromC.do", method = RequestMethod.GET)
    public String addToCart(Integer index, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Product product = user.getCompareList().get(index);
        Cart cart = new Cart();
        cart.setUID(user.getID());
        cart.setProduct_attr(product.getPID() + "-");
        cart.setQuantity(1);
        cart.setPrice(product.getPromotion_price());
        cartService.addProductToCart(cart);
        productService.removeFromCompare(user, index);
        user.setCartCount(user.getCartCount() + 1);
        return "forward:/getCart.do";
    }
}
