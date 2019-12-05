package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer PID);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer PID);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}