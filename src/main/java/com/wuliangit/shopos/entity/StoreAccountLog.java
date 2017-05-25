package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class StoreAccountLog {
    private Integer storeAccountLogId;

    private Integer storeId;

    private BigDecimal amount;

    private String type;

    private Integer orderId;

    private Date createTime;

    public Integer getStoreAccountLogId() {
        return storeAccountLogId;
    }

    public void setStoreAccountLogId(Integer storeAccountLogId) {
        this.storeAccountLogId = storeAccountLogId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}