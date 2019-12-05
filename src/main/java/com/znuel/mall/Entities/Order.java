package com.znuel.mall.Entities;

import java.util.Date;

public class Order {
    private Integer OID;

    private Date create_time;

    private String username;

    private Double total_amount;

    private Double promotion_amount;

    private Integer status;

    private String delivery_company;

    private String delivery_sn;

    private String receiver_name;

    private String receiver_phone;

    private String receiver_address;

    public Integer getOID() {
        return OID;
    }

    public void setOID(Integer OID) {
        this.OID = OID;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public Double getPromotion_amount() {
        return promotion_amount;
    }

    public void setPromotion_amount(Double promotion_amount) {
        this.promotion_amount = promotion_amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDelivery_company() {
        return delivery_company;
    }

    public void setDelivery_company(String delivery_company) {
        this.delivery_company = delivery_company == null ? null : delivery_company.trim();
    }

    public String getDelivery_sn() {
        return delivery_sn;
    }

    public void setDelivery_sn(String delivery_sn) {
        this.delivery_sn = delivery_sn == null ? null : delivery_sn.trim();
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name == null ? null : receiver_name.trim();
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone == null ? null : receiver_phone.trim();
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address == null ? null : receiver_address.trim();
    }
}