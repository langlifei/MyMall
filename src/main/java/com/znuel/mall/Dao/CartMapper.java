package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Cart;

public interface CartMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}