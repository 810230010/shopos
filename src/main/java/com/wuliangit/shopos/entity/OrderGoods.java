package com.wuliangit.shopos.entity;

import java.math.BigDecimal;

public class OrderGoods {
    private Integer orderGoodsId;

    private Integer orderCommonId;

    private Integer orderId;

    private Integer goodsId;

    private Integer goodsColorId;

    private String colorName;

    private String goodsName;

    private Integer goodsNum;

    private String goodsImage;

    private String colorImage;

    private BigDecimal goodsPayPrice;

    private Integer storeId;

    private Integer memberId;

    private String goodsType;

    private BigDecimal commissionPercent;

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Integer getOrderCommonId() {
        return orderCommonId;
    }

    public void setOrderCommonId(Integer orderCommonId) {
        this.orderCommonId = orderCommonId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsColorId() {
        return goodsColorId;
    }

    public void setGoodsColorId(Integer goodsColorId) {
        this.goodsColorId = goodsColorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName == null ? null : colorName.trim();
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

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    public String getColorImage() {
        return colorImage;
    }

    public void setColorImage(String colorImage) {
        this.colorImage = colorImage == null ? null : colorImage.trim();
    }

    public BigDecimal getGoodsPayPrice() {
        return goodsPayPrice;
    }

    public void setGoodsPayPrice(BigDecimal goodsPayPrice) {
        this.goodsPayPrice = goodsPayPrice;
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

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public BigDecimal getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(BigDecimal commissionPercent) {
        this.commissionPercent = commissionPercent;
    }
}