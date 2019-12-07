package com.znuel.mall.Vo;

import java.util.List;

public class CheckOutContent {

    private List<CheckOutItem> items;

    private double amount;

    public List<CheckOutItem> getItems() {
        return items;
    }

    public void setItems(List<CheckOutItem> items) {
        this.items = items;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
