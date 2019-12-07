package com.znuel.mall.Dao;

import com.znuel.mall.Entities.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);
}