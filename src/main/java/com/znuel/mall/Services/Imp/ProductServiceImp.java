package com.znuel.mall.Services.Imp;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.znuel.mall.Dao.ProductMapper;
import com.znuel.mall.Entities.Product;
import com.znuel.mall.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getDetailsById(Integer PId) {
        return productMapper.selectByPrimaryKey(PId);
    }
}
