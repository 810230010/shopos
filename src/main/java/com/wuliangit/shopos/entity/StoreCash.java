package com.wuliangit.shopos.entity;

import java.util.Date;

public class StoreCash {
    private Integer storeCashId;

    private String storeId;

    private String amount;

    private Date createTime;

    public Integer getStoreCashId() {
        return storeCashId;
    }

    public void setStoreCashId(Integer storeCashId) {
        this.storeCashId = storeCashId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}