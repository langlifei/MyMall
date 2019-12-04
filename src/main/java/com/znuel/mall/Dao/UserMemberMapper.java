package com.znuel.mall.Dao;

import com.znuel.mall.Entities.UserMember;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMemberMapper {

        int deleteByPrimaryKey(Integer id);

        @Insert("insert into user(username,password,nickname,phone,create_time,gender,birthday,city,job)" +
                " values(#{username},#{password},#{nickname},#{phone},#{createTime}," +
                "#{gender},#{birthday},#{city},#{job})")
        int insert(UserMember userMember);

        int insertSelective(UserMember record);

        @Select("select * from user where username=#{userName}")
        UserMember selectByUserName(String userName);
}
