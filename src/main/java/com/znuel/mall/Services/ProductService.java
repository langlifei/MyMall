package com.znuel.mall.Services;

import com.znuel.mall.Entities.Cart;
import com.znuel.mall.Entities.Product;
import com.znuel.mall.Entities.User;

public interface ProductService {

    //根据ID查询商品详细信息
    Product getDetailsById(Integer PID);

    //增加商品去比较
    boolean addToCompare(User user, Cart cart);

    //从比较中移除.
    void removeFromCompare(User user,Integer index);
}
