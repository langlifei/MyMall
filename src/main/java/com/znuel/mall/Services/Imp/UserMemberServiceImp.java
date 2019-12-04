package com.znuel.mall.Services.Imp;

import com.znuel.mall.Entities.UserMember;
import com.znuel.mall.Dao.UserMemberMapper;
import com.znuel.mall.Services.UserMemberService;
import com.znuel.mall.Util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserMemberServiceImp implements UserMemberService {

    @Autowired
    private UserMemberMapper userMapper;

    @Override
    public UserMember getByUsername(String username) {
        return userMapper.selectByUserName(username);
    }

    @Override
    public UserMember getById(Long id) {
        return null;
    }

    @Override
    public boolean register(UserMember userMember) {
        //设置用户创建时间
        Date date = new Date();
        userMember.setCreateTime(date);
        if(userMapper.insert(userMember) > 0)
            return true;
        else
            return false;
    }

    @Override
    public CommonResult generateAuthCode(String telephone) {
        return null;
    }

    @Override
    public CommonResult updatePassword(String telephone, String password, String authCode) {
        return null;
    }

    @Override
    public UserMember getCurrentMember() {
        return null;
    }

    @Override
    public UserMember loadUserByUsername(String username) {
        return null;
    }

    @Override
    public UserMember login(String username, String password) {
        UserMember user = userMapper.selectByUserName(username);
        if(user.getPassword().equals(password))
            return user;
        else
            return null;
    }
}
