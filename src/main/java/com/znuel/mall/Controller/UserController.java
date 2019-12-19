package com.znuel.mall.Controller;

import com.znuel.mall.Entities.User;
import com.znuel.mall.Services.CartService;
import com.znuel.mall.Services.UserService;
import com.znuel.mall.Services.WishListServer;
import com.znuel.mall.Util.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService Service;
    @Autowired
    private CartService cartService;
    @Autowired
    private WishListServer wishListServer;

    @ApiOperation("会员登录")
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(String username,String password, Model model, HttpServletRequest request) {
        User user = Service.login(username, password);
        if (user == null) {
            model.addAttribute("info","您输入的用户名或密码错误！");
            return "login";
        }else {
            //设置收藏中商品的个数
            user.setWishCount(wishListServer.getCount(user.getID()));
            //设置购物车中商品的个数
            user.setCartCount(cartService.getCount(user.getID()));
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return "redirect:content.do";
        }
//        Map<String, String> tokenMap = new HashMap<>();
//        tokenMap.put("token", token);
//        tokenMap.put("tokenHead", tokenHead);
//        tokenMap.put("tokenHead", tokenHead);
    }

    @ApiOperation("会员注册")
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String register(User user,HttpServletRequest request,Model model) throws ParseException {
        //设置时间日期
        String birthday = request.getParameter("birthDay");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        user.setBirthday(date);
        if(Service.register(user)){
            model.addAttribute("info","恭喜您,注册成功!");
        }else
            model.addAttribute("info","注册失败!");
        return "register";
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String password,
                                       @RequestParam String authCode) {
        return Service.updatePassword(telephone,password,authCode);
    }

    @ApiOperation("是否存在相同用户名")
    @RequestMapping(value="/checkUserName.do",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> isExistUserName(String username){
        Map<String,String> map = new HashMap<>();
       if(Service.getByUsername(username)!=null){
           map.put("flag","1");
       }else
           map.put("flag","0");
        return map;
    }

    //退出登录
    @RequestMapping(value = "/logout.do",method = RequestMethod.GET)
    public String logOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "login";
    }
}
