package com.znuel.mall.Dao;

import com.znuel.mall.Entities.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}