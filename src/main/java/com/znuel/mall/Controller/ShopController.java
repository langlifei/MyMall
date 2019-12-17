package com.znuel.mall.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.znuel.mall.Entities.Product;
import com.znuel.mall.Services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShopController {

    private final static int pageSize = 16;

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/queryAllProducts.do",method = RequestMethod.GET)
    public String getAllProducts(@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                 @RequestParam(name = "type",defaultValue = "0") Integer type ,
                                 @RequestParam(name = "keywords",defaultValue = "")String keywords,
                                 Model model){
        PageHelper.startPage(pageNum,16);
        List<Product> products = shopService.getProducts(type,keywords);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("type",type);
        model.addAttribute("keywords",keywords);
        return "shop";
    }
}
