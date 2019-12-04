package com.znuel.mall.Services;

import com.znuel.mall.Vo.HomeContentResult;
import com.znuel.mall.Entities.PmsProduct;

import java.util.List;

public interface HomeService {
    /**
     * 获取首页内容
     */
    HomeContentResult content();

    /**
     * 首页商品推荐
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     */
//    List<PmsProductCategory> getProductCateList(Long parentId);
//
//    /**
//     * 根据专题分类分页获取专题
//     * @param cateId 专题分类id
//     */
//    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);
}
