package com.wuliangit.shopos.entity;

import java.util.Date;

public class OrderCommon {
    private Integer orderCommonId;

    private Integer storeId;

    private Integer shippingTime;

    private Integer shippingExpressId;

    private Date evaluationTime;

    private String evalsellerState;

    private Integer evalsellerTime;

    private String orderMessage;

    private Integer orderPointscount;

    private Integer voucherPrice;

    private String voucherCode;

    private Integer areaId;

    private Integer cityId;

    private String areaInfo;

    private String address;

    private String telPhone;

    private String mobPhone;

    private String reciverName;

    private String reciverInfo;

    private Integer reciverProvinceId;

    private String invoiceInfo;

    private String promotionInfo;

    private String deliverExplain;

    public Integer getOrderCommonId() {
        return orderCommonId;
    }

    public void setOrderCommonId(Integer orderCommonId) {
        this.orderCommonId = orderCommonId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Integer shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Integer getShippingExpressId() {
        return shippingExpressId;
    }

    public void setShippingExpressId(Integer shippingExpressId) {
        this.shippingExpressId = shippingExpressId;
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public String getEvalsellerState() {
        return evalsellerState;
    }

    public void setEvalsellerState(String evalsellerState) {
        this.evalsellerState = evalsellerState == null ? null : evalsellerState.trim();
    }

    public Integer getEvalsellerTime() {
        return evalsellerTime;
    }

    public void setEvalsellerTime(Integer evalsellerTime) {
        this.evalsellerTime = evalsellerTime;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage == null ? null : orderMessage.trim();
    }

    public Integer getOrderPointscount() {
        return orderPointscount;
    }

    public void setOrderPointscount(Integer orderPointscount) {
        this.orderPointscount = orderPointscount;
    }

    public Integer getVoucherPrice() {
        return voucherPrice;
    }

    public void setVoucherPrice(Integer voucherPrice) {
        this.voucherPrice = voucherPrice;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode == null ? null : voucherCode.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo == null ? null : areaInfo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone == null ? null : telPhone.trim();
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone == null ? null : mobPhone.trim();
    }

    public String getReciverName() {
        return reciverName;
    }

    public void setReciverName(String reciverName) {
        this.reciverName = reciverName == null ? null : reciverName.trim();
    }

    public String getReciverInfo() {
        return reciverInfo;
    }

    public void setReciverInfo(String reciverInfo) {
        this.reciverInfo = reciverInfo == null ? null : reciverInfo.trim();
    }

    public Integer getReciverProvinceId() {
        return reciverProvinceId;
    }

    public void setReciverProvinceId(Integer reciverProvinceId) {
        this.reciverProvinceId = reciverProvinceId;
    }

    public String getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(String invoiceInfo) {
        this.invoiceInfo = invoiceInfo == null ? null : invoiceInfo.trim();
    }

    public String getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo == null ? null : promotionInfo.trim();
    }

    public String getDeliverExplain() {
        return deliverExplain;
    }

    public void setDeliverExplain(String deliverExplain) {
        this.deliverExplain = deliverExplain == null ? null : deliverExplain.trim();
    }
}