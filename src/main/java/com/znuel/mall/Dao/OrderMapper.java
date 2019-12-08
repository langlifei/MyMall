package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer OID);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer OID);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    @Select("select OID from order where delivery_sn = #{sn}")
    int selectOrderIdBySn(String sn);

    @Insert("insert into order(create_time,username,promotion_amount,status," +
            "delivery_company,delivery_sn,receiver_name,receiver_phone,receiver_address,notes) " +
            "values(#{create_time},#{username},#{promotion_amount},#{status},#{delivery_company}," +
            "#{delivery_sn},#{receiver_name},#{receiver_phone},#{receiver_address},#{notes})")
    int insertOrder(Order order);
}