package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer PID);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer PID);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> getProducts(@Param("type") int type,@Param("keywords") String keywords);
}