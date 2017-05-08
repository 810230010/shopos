package com.wuliangit.shopos.entity;

import java.util.Date;

public class Tuike {
    private Integer tuikeId;

    private Integer memberId;

    private String state;

    private Boolean isCheck;

    private Date createTime;

    private Date updateTime;

    private Long availableBalance;

    private Long freezeBalance;

    private String code;

    private String shareCount;

    private String buyCount;

    private String alipayAccount;

    private String bankCard;

    public Tuike(Integer tuikeId, Integer memberId, String state, Boolean isCheck, Date createTime, Date updateTime, Long availableBalance, Long freezeBalance, String code, String shareCount, String buyCount, String alipayAccount, String bankCard) {
        this.tuikeId = tuikeId;
        this.memberId = memberId;
        this.state = state;
        this.isCheck = isCheck;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.availableBalance = availableBalance;
        this.freezeBalance = freezeBalance;
        this.code = code;
        this.shareCount = shareCount;
        this.buyCount = buyCount;
        this.alipayAccount = alipayAccount;
        this.bankCard = bankCard;
    }

    public Tuike() {
        super();
    }

    public Integer getTuikeId() {
        return tuikeId;
    }

    public void setTuikeId(Integer tuikeId) {
        this.tuikeId = tuikeId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Boolean isCheck) {
        this.isCheck = isCheck;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getFreezeBalance() {
        return freezeBalance;
    }

    public void setFreezeBalance(Long freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getShareCount() {
        return shareCount;
    }

    public void setShareCount(String shareCount) {
        this.shareCount = shareCount == null ? null : shareCount.trim();
    }

    public String getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(String buyCount) {
        this.buyCount = buyCount == null ? null : buyCount.trim();
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount == null ? null : alipayAccount.trim();
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }
}