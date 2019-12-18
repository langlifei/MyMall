package com.znuel.mall.Vo;

import com.znuel.mall.Entities.Order;
import com.znuel.mall.Entities.Product;

import java.util.List;

public class OrderContent {

    private List<Product> products;

    private Order order;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
