package com.wuliangit.shopos.entity;

import java.util.Date;

public class SellerLog {
    private Integer sellerLogId;

    private String content;

    private Date createTime;

    private String storeUsername;

    private Integer sellerId;

    private String ip;

    public Integer getSellerLogId() {
        return sellerLogId;
    }

    public void setSellerLogId(Integer sellerLogId) {
        this.sellerLogId = sellerLogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStoreUsername() {
        return storeUsername;
    }

    public void setStoreUsername(String storeUsername) {
        this.storeUsername = storeUsername == null ? null : storeUsername.trim();
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}