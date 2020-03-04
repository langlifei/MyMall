package com.znuel.mall.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.znuel.mall.Entities.Product;
import com.znuel.mall.Entities.User;
import com.znuel.mall.Entities.WishList;
import com.znuel.mall.Services.WishListServer;
import com.znuel.mall.Vo.WishListContent;
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
public class WishListController {

    @Autowired
    private WishListServer wishListServer;

    private final static int pageSize = 5;

    @RequestMapping(value = "/addToWishList.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addToWishList(Integer id, HttpServletRequest request) {
        WishList wishList = new WishList();
        wishList.setPID(id);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        wishList.setUID(user.getID());
        Map<String, String> map = new HashMap<>();
        if (wishListServer.addToWishList(wishList)) {
            map.put("info", "添加成功!");
            user.setWishCount(user.getWishCount() + 1);
            map.put("wishCount", user.getWishCount() + "");
        } else
            map.put("info", "您已添加过此商品!");
        return map;
    }

    @RequestMapping(value = "/getWishList.do", method = RequestMethod.GET)
    public String getWishList(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PageHelper.startPage(pageNum, pageSize);
        List<WishListContent> products = wishListServer.getWishList(user.getID());
        PageInfo<WishListContent> pageInfo = new PageInfo<>(products);
        model.addAttribute("pageInfo", pageInfo);
        return "wishlist";
    }

    @RequestMapping(value = "/delProductFromWish.do", method = RequestMethod.GET)
    public String removeProduct(Integer id, HttpServletRequest request) {
        if (wishListServer.removeProduct(id)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            //将用户的收藏商品个数减一
            user.setWishCount(user.getWishCount() - 1);
        }
        ;
        return "forward:/getWishList.do";
    }
}
