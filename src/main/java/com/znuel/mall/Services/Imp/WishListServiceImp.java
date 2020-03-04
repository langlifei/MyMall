package com.znuel.mall.Services.Imp;

import com.znuel.mall.Dao.WishListMapper;
import com.znuel.mall.Entities.Product;
import com.znuel.mall.Entities.User;
import com.znuel.mall.Entities.WishList;
import com.znuel.mall.Services.WishListServer;
import com.znuel.mall.Vo.WishListContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class WishListServiceImp implements WishListServer {

    @Autowired
    private WishListMapper wishListMapper;

    @Override
    public boolean addToWishList(WishList wishList) {
        //判断商品在用户收藏中是否存在
        if (wishListMapper.selectByUIdAndPID(wishList.getUID(), wishList.getPID()) == null) {
            wishListMapper.insertSelective(wishList);
            return true;
        } else
            return false;
    }

    @Override
    public List<WishListContent> getWishList(Integer userId) {
        return wishListMapper.getWishList(userId);
    }

    @Override
    public boolean removeProduct(Integer id) {
        if (wishListMapper.deleteByPrimaryKey(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public int getCount(Integer userId) {
        return wishListMapper.getCount(userId);
    }

}
