package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BalanceCash {
    private Integer balanceCashId;

    private String balanceCashSn;

    private Integer memberId;

    private String memberName;

    private BigDecimal amount;

    private String bankName;

    private String bankNo;

    private String bankUser;

    private Date createTime;

    private Date paymentTime;

    private Boolean isPayment;

    private String paymentAdmin;

    public Integer getBalanceCashId() {
        return balanceCashId;
    }

    public void setBalanceCashId(Integer balanceCashId) {
        this.balanceCashId = balanceCashId;
    }

    public String getBalanceCashSn() {
        return balanceCashSn;
    }

    public void setBalanceCashSn(String balanceCashSn) {
        this.balanceCashSn = balanceCashSn == null ? null : balanceCashSn.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getBankUser() {
        return bankUser;
    }

    public void setBankUser(String bankUser) {
        this.bankUser = bankUser == null ? null : bankUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Boolean getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Boolean isPayment) {
        this.isPayment = isPayment;
    }

    public String getPaymentAdmin() {
        return paymentAdmin;
    }

    public void setPaymentAdmin(String paymentAdmin) {
        this.paymentAdmin = paymentAdmin == null ? null : paymentAdmin.trim();
    }
}