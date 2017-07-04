package com.wuliangit.shopos.entity;

import java.util.Date;

public class CommissionCashLog {
    private Integer commissionCashLogId;

    private Short takeCash;

    private String takeAccount;

    private Date takeTime;

    private String takeName;

    private Integer memberId;

    public Integer getCommissionCashLogId() {
        return commissionCashLogId;
    }

    public void setCommissionCashLogId(Integer commissionCashLogId) {
        this.commissionCashLogId = commissionCashLogId;
    }

    public Short getTakeCash() {
        return takeCash;
    }

    public void setTakeCash(Short takeCash) {
        this.takeCash = takeCash;
    }

    public String getTakeAccount() {
        return takeAccount;
    }

    public void setTakeAccount(String takeAccount) {
        this.takeAccount = takeAccount == null ? null : takeAccount.trim();
    }

    public Date getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(Date takeTime) {
        this.takeTime = takeTime;
    }

    public String getTakeName() {
        return takeName;
    }

    public void setTakeName(String takeName) {
        this.takeName = takeName == null ? null : takeName.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}