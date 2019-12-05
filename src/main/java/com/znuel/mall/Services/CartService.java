package com.znuel.mall.Services;

import com.znuel.mall.Entities.Cart;

public interface CartService {


    //添加商品到购物车
    public boolean addProductToCart(Cart cart);
}
