package com.znuel.mall.Config;

import com.znuel.mall.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:content.do");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截除了登录注册,和首页的所有请求
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login**", "/register**", "/content.do")
                .excludePathPatterns("/css/**", "/js/**", "/img/**", "/index.html", "/")
                .excludePathPatterns("/fonts/**", "/plugins/**", "/checkUserName.do");
    }
}
