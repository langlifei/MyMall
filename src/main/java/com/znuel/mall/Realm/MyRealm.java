package com.znuel.mall.Realm;

import com.znuel.mall.Entities.User;
import com.znuel.mall.Services.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

   //用于权限管理
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //用于用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.把AuthenticationToken转换为UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //2.从UsernamePasswordToken中获取username
        String username = token.getUsername();
        //3.调用数据库的方法,从数据库中查询username对应的用户记录.
        User user = userService.getByUsername(username);
        //4.如果用户不存在,则可以抛出unknownAccountException异常
        if(user == null){
            throw new UnknownAccountException("用户不存在!");
        }

        //5.根据用户的情况信息,决定是否需要抛出其他的Authentication异常


        /*6.根据用户的情况,来构建AuthenticationInfo对象并返回,通常使用的实现类是SimpleAuthenticationInfo
            1)principal:认证的实体信息,可以是username;
            2)credentials:密码.
            3)realmName:当前realm对象的name,调用父类的getName()方法即可.
            4)盐值.通过使用不同的盐值可以使得即使用户设置的密码相同,但加密后的密码不同.
        */
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,user.getPassword(),credentialsSalt,getName());
        return info;
    }
}
