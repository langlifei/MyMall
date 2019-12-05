package com.znuel.mall.Entities;

public class Categories {
    private Integer CID;

    private String CNAME;

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    public String getCNAME() {
        return CNAME;
    }

    public void setCNAME(String CNAME) {
        this.CNAME = CNAME == null ? null : CNAME.trim();
    }
}