package com.znuel.mall.Vo;

import com.znuel.mall.Entities.*;

import java.util.List;

public class HomeContentResult {
    //轮播广告
    private List<Advertise> advertiseList;
    //    //推荐品牌
//    private List<PmsBrand> brandList;
    //当前秒杀场次
    // private HomeFlashPromotion homeFlashPromotion;
    //新品推荐
    private List<Product> newProductList;
    //人气推荐
    private List<Product> hotProductList;

    public List<Advertise> getAdvertiseList() {
        return advertiseList;
    }

    public void setAdvertiseList(List<Advertise> advertiseList) {
        this.advertiseList = advertiseList;
    }
/*
    public HomeFlashPromotion getHomeFlashPromotion() {
        return homeFlashPromotion;
    }

    public void setHomeFlashPromotion(HomeFlashPromotion homeFlashPromotion) {
        this.homeFlashPromotion = homeFlashPromotion;
    }*/

    public List<Product> getNewProductList() {
        return newProductList;
    }

    public void setNewProductList(List<Product> newProductList) {
        this.newProductList = newProductList;
    }

    public List<Product> getHotProductList() {
        return hotProductList;
    }

    public void setHotProductList(List<Product> hotProductList) {
        this.hotProductList = hotProductList;
    }

}
