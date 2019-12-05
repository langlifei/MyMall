package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Categories;

public interface CategoriesMapper {
    int deleteByPrimaryKey(Integer CID);

    int insert(Categories record);

    int insertSelective(Categories record);

    Categories selectByPrimaryKey(Integer CID);

    int updateByPrimaryKeySelective(Categories record);

    int updateByPrimaryKey(Categories record);
}