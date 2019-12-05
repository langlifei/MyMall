package com.znuel.mall.Services.Imp;

import com.znuel.mall.Dao.CartMapper;
import com.znuel.mall.Entities.Cart;
import com.znuel.mall.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public boolean addProductToCart(Cart cart) {
        //1表示该商品存在于购物车,但未下单
        cart.setStatus(1);
        //设置创建时间
        Date date = new Date();
        cart.setCreate_time(date);
        if(cartMapper.insert(cart) > 0)
            return true;
        else
            return false;
    }
}
