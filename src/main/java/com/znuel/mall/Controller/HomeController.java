package com.znuel.mall.Controller;

import com.znuel.mall.Services.HomeService;
import com.znuel.mall.Util.CommonResult;
import com.znuel.mall.Vo.HomeContentResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ApiOperation("首页内容页信息展示")
    @RequestMapping(value = "/content.do", method = RequestMethod.GET)
    public String content(Model model) {
        HomeContentResult contentResult = homeService.content();
        model.addAttribute("homeContent", contentResult);
        return "index";
    }
}
