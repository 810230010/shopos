package com.wuliangit.shopos.entity;

import java.math.BigDecimal;

public class OrderGoods {
    private Integer orderGoodsId;

    private Integer orderCommonId;

    private Integer goodsSkuId;

    private Integer orderId;

    private Integer goodsId;

    private String skuName;

    private String goodsName;

    private Integer goodsNum;

    private String goodsImage;

    private BigDecimal goodsPayPrice;

    private Integer storeId;

    private Integer memberId;

    private String goodsType;

    private BigDecimal commission;

    public OrderGoods(Integer orderGoodsId, Integer orderCommonId, Integer goodsSkuId, Integer orderId, Integer goodsId, String skuName, String goodsName, Integer goodsNum, String goodsImage, BigDecimal goodsPayPrice, Integer storeId, Integer memberId, String goodsType, BigDecimal commission) {
        this.orderGoodsId = orderGoodsId;
        this.orderCommonId = orderCommonId;
        this.goodsSkuId = goodsSkuId;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.skuName = skuName;
        this.goodsName = goodsName;
        this.goodsNum = goodsNum;
        this.goodsImage = goodsImage;
        this.goodsPayPrice = goodsPayPrice;
        this.storeId = storeId;
        this.memberId = memberId;
        this.goodsType = goodsType;
        this.commission = commission;
    }

    public OrderGoods() {
        super();
    }

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

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
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

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
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

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }
}