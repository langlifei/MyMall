package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Order;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer OID);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer OID);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    @Select("select OID from mallorder where delivery_sn = #{sn}")
    int selectOrderIdBySn(String sn);
}