package com.znuel.mall.Services.Imp;

import com.znuel.mall.Dao.UserMapper;
import com.znuel.mall.Entities.User;
import com.znuel.mall.Services.UserService;
import com.znuel.mall.Util.CommonResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public boolean register(User user) {
        //设置用户创建时间
        Date date = new Date();
        user.setCreate_time(date);
        //对密码使用md5算法进行加密,并使用用户名作为盐值,以免数据库中出现相同密码,加密次数为1024次.
        String newPassword = new Md5Hash(user.getPassword(), ByteSource.Util.bytes(user.getUsername()),1024).toString();
        //使用加密后的密码
        user.setPassword(newPassword);
        if (userMapper.insert(user) > 0)
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
    public User getCurrentMember() {
        return null;
    }

    @Override
    public User loadUserByUsername(String username) {
        return null;
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password))
                return user;
            else
                return null;
        } else
            return null;
    }
}
