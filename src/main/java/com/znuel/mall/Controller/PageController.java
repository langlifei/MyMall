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
        return "index";
    }
    @RequestMapping("/404.html")
    public String error(){
        return "404";
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
        return "shop";
    }
    @RequestMapping("/wishlist.html")
    public String wishlist(){
        return "wishlist";
    }
    @RequestMapping("/cart.html")
    public String cart(){
        return "cart";
    }
}
