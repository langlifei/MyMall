package com.znuel.mall.Services.Imp;

import com.znuel.mall.Entities.UmsMember;
import com.znuel.mall.Mapper.UmsMemberMapper;
import com.znuel.mall.Services.UmsMemberService;
import com.znuel.mall.Util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsmMemberServiceImp implements UmsMemberService {

    @Autowired
    private UmsMemberMapper userMapper;

    @Override
    public UmsMember getByUsername(String username) {
        return null;
    }

    @Override
    public UmsMember getById(Long id) {
        return null;
    }

    @Override
    public CommonResult register(String username, String password, String telephone, String authCode) {
        return null;
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
    public UmsMember getCurrentMember() {
        return null;
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {

    }

    @Override
    public UmsMember loadUserByUsername(String username) {
        return null;
    }

    @Override
    public UmsMember login(String username, String password) {
        UmsMember user = userMapper.selectByUserName(username);
        if(user.getPassword().equals(password))
            return user;
        else
            return null;
    }
}
