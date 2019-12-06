package com.znuel.mall.Services;

import com.znuel.mall.Entities.Product;
import com.znuel.mall.Entities.WishList;
import com.znuel.mall.Vo.WishListContent;

import java.util.List;

public interface WishListServer {

    //添加商品到愿望清单
    public boolean addToWishList(WishList wishList);

    //从愿望清单中查询所有商品
    public List<WishListContent> getWishList(Integer userID);

    //从收藏中移除商品
    public boolean removeProduct(Integer id);

    //统计用户收藏中的商品个数
    public int getCount(Integer userId);
}
