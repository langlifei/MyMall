package com.znuel.mall.Services.Imp;

import com.znuel.mall.Dao.AdvertiseMapper;
import com.znuel.mall.Entities.Advertise;
import com.znuel.mall.Entities.Product;
import com.znuel.mall.Dao.HomeMapper;
import com.znuel.mall.Services.HomeService;
import com.znuel.mall.Vo.HomeContentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImp implements HomeService {

    @Autowired
    private AdvertiseMapper advertiseMapper;
    @Autowired
    private HomeMapper homeDao;
//    @Autowired
//    private SmsFlashPromotionMapper flashPromotionMapper;
//    @Autowired
//    private SmsFlashPromotionSessionMapper promotionSessionMapper;
//    @Autowired
//    private PmsProductMapper productMapper;
//    @Autowired
//    private PmsProductCategoryMapper productCategoryMapper;
//    @Autowired
//    private CmsSubjectMapper subjectMapper;

    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();

        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取推荐品牌
        //result.setBrandList(homeDao.getRecommendBrandList(0,4));
        //获取秒杀信息
        //result.setHomeFlashPromotion(getHomeFlashPromotion());
        //获取新品推荐
        result.setNewProductList(homeDao.getNewProductList(8));
        //获取人气推荐
        //result.setHotProductList(homeDao.getHotProductList(0,5));
        return result;
    }

    @Override
    public List<Product> recommendProductList(Integer pageSize, Integer pageNum) {
        return null;
    }

    private List<Advertise> getHomeAdvertiseList() {
        List<Advertise> removedList = new ArrayList<>();
        List<Advertise> list = advertiseMapper.getAllHomeAdvertise();
        //移除所有状态为0的广告
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus() == 1)
                removedList.add(list.get(i));
        }
        return removedList;
    }

}
