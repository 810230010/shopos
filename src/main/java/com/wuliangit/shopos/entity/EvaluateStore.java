package com.wuliangit.shopos.entity;

public class EvaluateStore {
    private Integer sevalId;

    private Integer orderId;

    private String orderNo;

    private Integer createTime;

    private Integer storeId;

    private String storeName;

    private Integer memberId;

    private String memberName;

    private Integer descCredit;

    private Integer serviceCredit;

    private Integer deliveryCredit;

    public Integer getSevalId() {
        return sevalId;
    }

    public void setSevalId(Integer sevalId) {
        this.sevalId = sevalId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
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

    public Integer getDescCredit() {
        return descCredit;
    }

    public void setDescCredit(Integer descCredit) {
        this.descCredit = descCredit;
    }

    public Integer getServiceCredit() {
        return serviceCredit;
    }

    public void setServiceCredit(Integer serviceCredit) {
        this.serviceCredit = serviceCredit;
    }

    public Integer getDeliveryCredit() {
        return deliveryCredit;
    }

    public void setDeliveryCredit(Integer deliveryCredit) {
        this.deliveryCredit = deliveryCredit;
    }
}