package com.znuel.mall.Services.Imp;

import com.znuel.mall.Dao.ProductMapper;
import com.znuel.mall.Entities.Product;
import com.znuel.mall.Services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImp implements ShopService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProducts(Integer type,String keywords) {
        if(keywords != null && !"".equals(keywords)){
            keywords = "%"+keywords+"%";
        }
        return productMapper.getProducts(type,keywords);
    }
}
