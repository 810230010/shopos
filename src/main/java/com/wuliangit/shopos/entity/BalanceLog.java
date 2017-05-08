package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BalanceLog {
    private Integer balanceLogId;

    private Integer memberId;

    private String memberName;

    private String adminName;

    private String type;

    private BigDecimal avAmount;

    private BigDecimal freezeAmount;

    private Date createTime;

    private String desc;

    public BalanceLog(Integer balanceLogId, Integer memberId, String memberName, String adminName, String type, BigDecimal avAmount, BigDecimal freezeAmount, Date createTime, String desc) {
        this.balanceLogId = balanceLogId;
        this.memberId = memberId;
        this.memberName = memberName;
        this.adminName = adminName;
        this.type = type;
        this.avAmount = avAmount;
        this.freezeAmount = freezeAmount;
        this.createTime = createTime;
        this.desc = desc;
    }

    public BalanceLog() {
        super();
    }

    public Integer getBalanceLogId() {
        return balanceLogId;
    }

    public void setBalanceLogId(Integer balanceLogId) {
        this.balanceLogId = balanceLogId;
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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getAvAmount() {
        return avAmount;
    }

    public void setAvAmount(BigDecimal avAmount) {
        this.avAmount = avAmount;
    }

    public BigDecimal getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(BigDecimal freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}