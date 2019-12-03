package com.znuel.mall.Controller;

import com.znuel.mall.Entities.UmsMember;
import com.znuel.mall.Services.UmsMemberService;
import com.znuel.mall.Util.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("会员登录")
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(String username,String password, Model model, HttpServletRequest request) {
        UmsMember user = memberService.login(username, password);
        if (user == null) {
            model.addAttribute("info","您输入的用户名或密码错误！");
            return "login";
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return "index";
        }
//        Map<String, String> tokenMap = new HashMap<>();
//        tokenMap.put("token", token);
//        tokenMap.put("tokenHead", tokenHead);
//        tokenMap.put("tokenHead", tokenHead);
    }

    @ApiOperation("会员注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telephone,
                                 @RequestParam String authCode) {
        return memberService.register(username, password, telephone, authCode);
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String password,
                                       @RequestParam String authCode) {
        return memberService.updatePassword(telephone,password,authCode);
    }

}
