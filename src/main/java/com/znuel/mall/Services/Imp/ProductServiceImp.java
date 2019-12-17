package com.znuel.mall.Services.Imp;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.znuel.mall.Dao.ProductMapper;
import com.znuel.mall.Entities.Cart;
import com.znuel.mall.Entities.Product;
import com.znuel.mall.Entities.User;
import com.znuel.mall.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getDetailsById(Integer PId) {
        return productMapper.selectByPrimaryKey(PId);
    }

    @Override
    public boolean addToCompare(User user, Cart cart) {
        List<Product> compareProduct = user.getCompareList();
        //最多比较三个
        for( int i = 0 ; i < compareProduct.size();i++){
            if(compareProduct.get(i) == null){
                Product product = new Product();
                //获取PID
                String[] str = cart.getProduct_attr().split("-");
                product = productMapper.selectByPrimaryKey(new Integer(str[0]));
                compareProduct.set(i,product);
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeFromCompare(User user, Integer index) {
        List<Product> compareProduct = user.getCompareList();
        compareProduct.set(index,null);
    }
}
