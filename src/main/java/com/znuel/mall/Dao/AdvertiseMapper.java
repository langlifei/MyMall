package com.znuel.mall.Dao;

import com.znuel.mall.Entities.Advertise;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdvertiseMapper {
    int deleteByPrimaryKey(Integer AID);

    int insert(Advertise record);

    int insertSelective(Advertise record);

    Advertise selectByPrimaryKey(Integer AID);

    int updateByPrimaryKeySelective(Advertise record);

    int updateByPrimaryKey(Advertise record);

    @Select("select * from advertise")
    List<Advertise> getAllHomeAdvertise();
}