package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Refund {
    private Integer refundId;

    private Integer orderId;

    private String orderOutTradeNo;

    private Integer storeId;

    private Integer memberId;

    private String memberUsername;

    private Integer goodsId;

    private String goodsName;

    private Integer goodsNum;

    private String skuName;

    private BigDecimal refundAmount;

    private String goodsImage;

    private String orderGoodsType;

    private String refundType;

    private String refundState;

    private Boolean isLock;

    private String goodsState;

    private Date createTime;

    private Date sellerHandleTime;

    private Date adminTime;

    private String picsInfo;

    private String buyerMessage;

    private String sellerMessage;

    private String adminMessage;

    private String expressName;

    private String expressCode;

    private String expressNo;

    private String refundAddress;

    private String refundName;

    private String refundPhone;

    private Date refundTime;

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderOutTradeNo() {
        return orderOutTradeNo;
    }

    public void setOrderOutTradeNo(String orderOutTradeNo) {
        this.orderOutTradeNo = orderOutTradeNo == null ? null : orderOutTradeNo.trim();
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername == null ? null : memberUsername.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    public String getOrderGoodsType() {
        return orderGoodsType;
    }

    public void setOrderGoodsType(String orderGoodsType) {
        this.orderGoodsType = orderGoodsType == null ? null : orderGoodsType.trim();
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType == null ? null : refundType.trim();
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState == null ? null : refundState.trim();
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState == null ? null : goodsState.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSellerHandleTime() {
        return sellerHandleTime;
    }

    public void setSellerHandleTime(Date sellerHandleTime) {
        this.sellerHandleTime = sellerHandleTime;
    }

    public Date getAdminTime() {
        return adminTime;
    }

    public void setAdminTime(Date adminTime) {
        this.adminTime = adminTime;
    }

    public String getPicsInfo() {
        return picsInfo;
    }

    public void setPicsInfo(String picsInfo) {
        this.picsInfo = picsInfo == null ? null : picsInfo.trim();
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage == null ? null : buyerMessage.trim();
    }

    public String getSellerMessage() {
        return sellerMessage;
    }

    public void setSellerMessage(String sellerMessage) {
        this.sellerMessage = sellerMessage == null ? null : sellerMessage.trim();
    }

    public String getAdminMessage() {
        return adminMessage;
    }

    public void setAdminMessage(String adminMessage) {
        this.adminMessage = adminMessage == null ? null : adminMessage.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode == null ? null : expressCode.trim();
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo == null ? null : expressNo.trim();
    }

    public String getRefundAddress() {
        return refundAddress;
    }

    public void setRefundAddress(String refundAddress) {
        this.refundAddress = refundAddress == null ? null : refundAddress.trim();
    }

    public String getRefundName() {
        return refundName;
    }

    public void setRefundName(String refundName) {
        this.refundName = refundName == null ? null : refundName.trim();
    }

    public String getRefundPhone() {
        return refundPhone;
    }

    public void setRefundPhone(String refundPhone) {
        this.refundPhone = refundPhone == null ? null : refundPhone.trim();
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }
}