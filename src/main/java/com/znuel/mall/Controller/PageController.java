package com.znuel.mall.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("/register.html")
    public String register(){
        return "register";
    }

    @RequestMapping("/index.html")
    public String index(){
        return "forward:/content.do";
    }
    @RequestMapping("/error.html")
    public String error(){
        return "error";
    }

    @RequestMapping("/about.html")
    public String about(){
        return "about";
    }

    @RequestMapping("/checkout.html")
    public String checkout(){
        return "checkout";
    }

    @RequestMapping("/compare.html")
    public String compare(){
        return "compare";
    }
    @RequestMapping("/contact.html")
    public String contact(){
        return "contact";
    }
    @RequestMapping("/forgot-password.html")
    public String forgotedPassword(){
        return "forgot-password";
    }
    @RequestMapping("/product.html")
    public String product(){
        return "product";
    }
    @RequestMapping("/shop.html")
    public String shop(){
        return "forward:/queryAllProducts.do?pageNum=1";
    }
    @RequestMapping("/wishlist.html")
    public String wishlist(){
        return "forward:/getWishList.do";
    }
    @RequestMapping("/cart.html")
    public String cart(){
        return "forward:/getCart.do";
    }
}
