package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Order;
import com.znuel.mall.Entities.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer OID);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer OID);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    @Select("select OID from mallorder where delivery_sn = #{sn}")
    int selectOrderIdBySn(String sn);

    @Select("select * from mallorder where username=#{username} order by create_time desc")
    List<Order> getOrders(String username);

    //将商品数量存放在stock中,将总价存放在price中
    @Select("select p.PID,p.PName,p.pic,oi.productTotalAmount/oi.productNumber as price,oi.productTotalAmount/oi.productNumber as promotion_price,oi.productNumber as stock,p.promotion_end_time from order_item oi left join product p on oi.PID = p.PID where OID = #{orderId}")
    List<Product> getProducts(Integer orderId);
}