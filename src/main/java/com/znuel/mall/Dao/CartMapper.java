package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Cart;
import com.znuel.mall.Vo.CartContent;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    //查找购物车中存在的商品
    @Select("select cart.ID as id,product.PID as pId , product.pic,product.PName as productName,cart.price as promotion_price,cart.quantity,cart.price*cart.quantity as totalAmount,cart.product_attr from cart left join product on cart.PID = product.PID " +
            "where cart.UID = #{userId} and cart.status = 1 order by cart.create_time DESC")
    List<CartContent> selectByUserId(Integer userId);

 /*   //修改购物车中商品的状态.
    @Select("update cart set status = #{status} where ID = #{ID}")
    int updateProductStatus(Cart cart);*/

    //统计用户在购物车中商品个数
    @Select("select count(*) from cart where UID = #{userId} and status = 1")
    int getCount(Integer userId);

    //设置购买后的商品状态为2
    int removeProduct(List list);
}