package com.znuel.mall.Entities;

import java.text.DecimalFormat;
import java.util.Date;

public class Cart {
    private Integer ID;

    private Integer PID;

    private Integer UID;

    private Integer quantity;

    private Double price;

    private Date create_time;

    private String product_attr;

    private Integer status;

    DecimalFormat df = new DecimalFormat( "0.00 ");

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if(price >=0)
            this.price = new Double(df.format(price));
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getProduct_attr() {
        return product_attr;
    }

    public void setProduct_attr(String product_attr) {
        this.product_attr = product_attr == null ? null : product_attr.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}