package com.wuliangit.shopos.entity;

import java.util.Date;

public class OrderCommission {
    private Integer orderCommissionId;

    private Integer orderId;

    private Short commission;

    private String tuikeCode;

    private Integer memberId;

    private Date creatTime;

    private String memberName;

    public Integer getOrderCommissionId() {
        return orderCommissionId;
    }

    public void setOrderCommissionId(Integer orderCommissionId) {
        this.orderCommissionId = orderCommissionId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Short getCommission() {
        return commission;
    }

    public void setCommission(Short commission) {
        this.commission = commission;
    }

    public String getTuikeCode() {
        return tuikeCode;
    }

    public void setTuikeCode(String tuikeCode) {
        this.tuikeCode = tuikeCode == null ? null : tuikeCode.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }
}