package com.znuel.mall.Services;

import com.znuel.mall.Entities.Cart;
import com.znuel.mall.Vo.CartContent;
import com.znuel.mall.Vo.CheckOutContent;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CartService {

    //添加商品到购物车
    public boolean addProductToCart(Cart cart);

    //查询购物车中所有商品信息
    public List<CartContent> queryCart(Integer userId);

    //移除购物车中的商品
    public boolean removeProduct(Integer ID);

    //计算购物车中商品的总额
    public double computeAmount(List<CartContent> contents);

    //统计用户购物车中商品个数
    public int getCount(Integer userId);

    //将购物车被选中的商品送去结账...
    public CheckOutContent toCheckOut(String jsonStr);

    //下单后移除购物车中已下单的商品
    public void removeProductAfterPO(HttpServletRequest request);
}
