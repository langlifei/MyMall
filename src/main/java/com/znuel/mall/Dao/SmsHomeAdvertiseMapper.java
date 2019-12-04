package com.znuel.mall.Dao;

import com.znuel.mall.Entities.SmsHomeAdvertise;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SmsHomeAdvertiseMapper {

    @Select("select * from advertise")
    public List<SmsHomeAdvertise> getAllSmsHomeAdvertise();
}
