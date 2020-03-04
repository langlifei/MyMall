package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 首页内容管理自定义Dao
 * Created by macro on 2019/1/28.
 */
public interface HomeMapper {

//    /**
//     * 获取推荐品牌
//     */
//    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);
//
//    /**
//     * 获取秒杀商品
//     */
//    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * 获取新品推荐,number为每个类别的个数.
     */
    @Select("select a.* from product a where (select count(*) from product b where a.CID = b.CID and unix_timestamp(b.create_time) > unix_timestamp(a.create_time)) < #{number} order by CID,create_time desc")
    List<Product> getNewProductList(Integer number);

    /**
     * 获取人气推荐
     */
    List<Product> getHotProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取推荐专题
     */
    //List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
