package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TradeRefund {
    private Integer tradeRefundId;

    private String outRequestNo;

    private String paymentCode;

    private BigDecimal amount;

    private Integer orderId;

    private Date createTime;

    public Integer getTradeRefundId() {
        return tradeRefundId;
    }

    public void setTradeRefundId(Integer tradeRefundId) {
        this.tradeRefundId = tradeRefundId;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo == null ? null : outRequestNo.trim();
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode == null ? null : paymentCode.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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