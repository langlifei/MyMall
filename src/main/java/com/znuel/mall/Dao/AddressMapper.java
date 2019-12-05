package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer aID);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer aID);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}