package com.znuel.mall.Vo;

import io.swagger.models.auth.In;

import java.text.DecimalFormat;

public class CartContent {


    //购物车中商品的总额
    private double total;

    //购物车编号
    private Integer id;

    //商品编号
    private Integer pId;

    private String pic;

    private String productName;

    private double promotion_price;

    private Integer quantity;

    private double totalAmount;

    private String product_attr;

    DecimalFormat df = new DecimalFormat( "0.00 ");

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

    public double getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(double promotion_price) {
        if(promotion_price >=0)
            this.promotion_price = new Double(df.format(promotion_price));
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        if(quantity >= 0)
            this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        if(totalAmount >=0)
            this.totalAmount = new Double(df.format(totalAmount));
    }

    public String getProduct_attr() {
        return product_attr;
    }

    public void setProduct_attr(String product_attr) {
        this.product_attr = product_attr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        if(total >=0)
            this.total = new Double(df.format(total));
    }
}
