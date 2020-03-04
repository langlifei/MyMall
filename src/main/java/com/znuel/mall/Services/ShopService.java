package com.znuel.mall.Services;

import com.znuel.mall.Entities.Product;

import java.util.List;

public interface ShopService {

    public List<Product> getProducts(Integer type, String keywords);
}
