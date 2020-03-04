package com.znuel.mall.Vo;

import java.text.DecimalFormat;

public class WishListContent {
    private Integer pId;

    private Integer wId;

    private String pic;

    private String productName;

    private double price;

    private Integer status;

    DecimalFormat df = new DecimalFormat("0.00 ");

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0)
            this.price = new Double(df.format(price));
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
