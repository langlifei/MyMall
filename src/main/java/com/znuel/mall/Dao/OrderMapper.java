package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer OID);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer OID);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}