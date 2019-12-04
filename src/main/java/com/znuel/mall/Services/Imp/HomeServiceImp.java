package com.znuel.mall.Services.Imp;

import com.znuel.mall.Entities.SmsHomeAdvertise;
import com.znuel.mall.Dao.HomeMapper;
import com.znuel.mall.Dao.SmsHomeAdvertiseMapper;
import com.znuel.mall.Services.HomeService;
import com.znuel.mall.Vo.HomeContentResult;
import com.znuel.mall.Entities.PmsProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImp implements HomeService {

    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;
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
        result.setNewProductList(homeDao.getNewProductList(0,8));
        //获取人气推荐
        result.setHotProductList(homeDao.getHotProductList(0,5));
        return result;
    }

    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        return null;
    }

  /* private HomeFlashPromotion getHomeFlashPromotion() {
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //获取当前秒杀活动
        Date now = new Date();
        SmsFlashPromotion flashPromotion = getFlashPromotion(now);
        if (flashPromotion != null) {
            //获取当前秒杀场次
            SmsFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
            if (flashPromotionSession != null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
                //获取下一个秒杀场次
                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
                if(nextSession!=null){
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                //获取秒杀商品
                List<FlashPromotionProduct> flashProductList = homeDao.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;
    }*/

//    //获取下一个场次信息
//    private SmsFlashPromotionSession getNextFlashPromotionSession(Date date) {
//        SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
//        sessionExample.createCriteria()
//                .andStartTimeGreaterThan(date);
//        sessionExample.setOrderByClause("start_time asc");
//        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
//        if (!CollectionUtils.isEmpty(promotionSessionList)) {
//            return promotionSessionList.get(0);
//        }
//        return null;
//    }

    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        List<SmsHomeAdvertise> removedList = new ArrayList<>();
        List<SmsHomeAdvertise> list = advertiseMapper.getAllSmsHomeAdvertise();
        //移除所有状态为0的广告
        for (int i = 0 ; i < list.size();i++){
            if(list.get(i).getStatus() == 1)
                removedList.add(list.get(i));
        }
        return removedList;
    }

//    //根据时间获取秒杀活动
//    private SmsFlashPromotion getFlashPromotion(Date date) {
//      //  Date currDate = DateUtil.getDate(date);
//        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
//        example.createCriteria()
//                .andStatusEqualTo(1)
//                .andStartDateLessThanOrEqualTo(currDate)
//                .andEndDateGreaterThanOrEqualTo(currDate);
//        List<SmsFlashPromotion> flashPromotionList = flashPromotionMapper.selectByExample(example);
//        if (!CollectionUtils.isEmpty(flashPromotionList)) {
//            return flashPromotionList.get(0);
//        }
//        return null;
//    }
//
//    //根据时间获取秒杀场次
//    private SmsFlashPromotionSession getFlashPromotionSession(Date date) {
//        Date currTime = DateUtil.getTime(date);
//        SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
//        sessionExample.createCriteria()
//                .andStartTimeLessThanOrEqualTo(currTime)
//                .andEndTimeGreaterThanOrEqualTo(currTime);
//        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
//        if (!CollectionUtils.isEmpty(promotionSessionList)) {
//            return promotionSessionList.get(0);
//        }
//        return null;
//    }
}
