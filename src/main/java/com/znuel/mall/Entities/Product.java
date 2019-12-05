package com.znuel.mall.Entities;

import java.util.Date;

public class Product {
    private Integer PID;

    private String PName;

    private String pic;

    private Double price;

    private Double promotion_price;

    private Integer CID;

    private Date promotion_start_time;

    private Date promotion_end_time;

    private Date create_time;

    private Integer status;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName == null ? null : PName.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(Double promotion_price) {
        this.promotion_price = promotion_price;
    }

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    public Date getPromotion_start_time() {
        return promotion_start_time;
    }

    public void setPromotion_start_time(Date promotion_start_time) {
        this.promotion_start_time = promotion_start_time;
    }

    public Date getPromotion_end_time() {
        return promotion_end_time;
    }

    public void setPromotion_end_time(Date promotion_end_time) {
        this.promotion_end_time = promotion_end_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}