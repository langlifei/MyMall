package com.znuel.mall.Mapper;

import com.znuel.mall.Entities.UmsMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface UmsMemberMapper {
        int deleteByPrimaryKey(Long id);

        int insert(UmsMember record);

        int insertSelective(UmsMember record);

        @Select("select * from ums_member where username=#{userName}")
        UmsMember selectByUserName(String userName);
}
