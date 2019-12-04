package com.znuel.mall.Services;

import com.znuel.mall.Entities.UserMember;
import com.znuel.mall.Util.CommonResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理Service
 * Created by macro on 2018/8/3.
 */
public interface UserMemberService {
    /**
     * 根据用户名获取会员
     */
    UserMember getByUsername(String username);

    /**
     * 根据会员编号获取会员
     */
    UserMember getById(Long id);

    /**
     * 用户注册
     */
    boolean register(UserMember userMember);

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 修改密码
     */
    @Transactional
    CommonResult updatePassword(String telephone, String password, String authCode);

    /**
     * 获取当前登录会员
     */
    UserMember getCurrentMember();


    /**
     * 获取用户信息
     */
    UserMember loadUserByUsername(String username);

    /**
     * 登录后获取token
     */
    UserMember login(String username, String password);
}
