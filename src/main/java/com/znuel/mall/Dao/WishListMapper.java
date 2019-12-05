package com.znuel.mall.Dao;

import com.znuel.mall.Entities.WishList;

public interface WishListMapper {
    int deleteByPrimaryKey(Integer WID);

    int insert(WishList record);

    int insertSelective(WishList record);

    WishList selectByPrimaryKey(Integer WID);

    int updateByPrimaryKeySelective(WishList record);

    int updateByPrimaryKey(WishList record);
}