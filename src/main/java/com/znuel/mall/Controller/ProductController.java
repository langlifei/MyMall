package com.znuel.mall.Controller;

import com.znuel.mall.Entities.Product;
import com.znuel.mall.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product.do",method = RequestMethod.GET)
    public String productDetail(Integer id, Model model){
        Product product = productService.getDetailsById(id);
        model.addAttribute("productDetail",product);
        return "product";
    }

}
