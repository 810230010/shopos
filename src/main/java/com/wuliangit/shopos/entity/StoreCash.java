package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class StoreCash {
    private Integer storeCashId;

    private Integer storeId;

    private BigDecimal amount;

    private Date createTime;

    private String outBizNo;

    public Integer getStoreCashId() {
        return storeCashId;
    }

    public void setStoreCashId(Integer storeCashId) {
        this.storeCashId = storeCashId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo == null ? null : outBizNo.trim();
    }
}