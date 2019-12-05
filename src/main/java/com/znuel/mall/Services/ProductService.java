package com.znuel.mall.Services;

import com.znuel.mall.Entities.Product;

public interface ProductService {

    //根据ID查询商品详细信息
    Product getDetailsById(Integer PID);
}
