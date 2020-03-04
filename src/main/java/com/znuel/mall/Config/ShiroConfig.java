package com.znuel.mall.Config;

import com.znuel.mall.Realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //Filter工厂,设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        //设置验证成功跳转页面
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        //设置登录页面
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        //设置验证不通过跳转页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/login");

      //  Map<String,String> filterChain = new LinkedHashMap<>();
//        System.out.println("过滤器注册成功!!!!!!!!-------------------");

        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(HashedCredentialsMatcher hashedCredentialsMatcher){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置验证方式.
        securityManager.setRealm(myRealm(hashedCredentialsMatcher));
        return securityManager;
    }

    //配置密码校验规则
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1024);
        return matcher;
    }

    @Bean
    public MyRealm myRealm(HashedCredentialsMatcher hashedCredentialsMatcher){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return myRealm;
    }
}
