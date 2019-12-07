package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Product;
import com.znuel.mall.Entities.WishList;
import com.znuel.mall.Vo.WishListContent;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WishListMapper {
    int deleteByPrimaryKey(Integer WID);

    int insert(WishList record);

    int insertSelective(WishList record);

    WishList selectByPrimaryKey(Integer WID);

    int updateByPrimaryKeySelective(WishList record);

    int updateByPrimaryKey(WishList record);

    @Select("select p.PID AS pId,wishlist.WID as wId,p.pic,p.PName as productName,p.price,p.`status` from product p left join wishlist on p.PID = wishlist.PID where wishlist.UID = #{userId}")
    List<WishListContent> getWishList(Integer userId);

    //统计用户的收藏商品个数
    @Select("select count(*) from wishlist where UID = #{userId}")
    int getCount(Integer userId);

    //判断商品是否已存在收藏中.
    @Select("select * from wishlist where UID = #{userId} and PID = #{PID}")
    WishList selectByUIdAndPID(Integer userId,Integer PID);
}