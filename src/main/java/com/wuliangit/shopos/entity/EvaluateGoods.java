package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class EvaluateGoods {
    private Integer evaluateGoodsId;

    private Integer orderId;

    private String orderSn;

    private Integer orderGoodsId;

    private Integer goodsId;

    private String goodsName;

    private BigDecimal goodsPrice;

    private String goodsImages;

    private Integer scores;

    private String content;

    private Boolean isAnonymous;

    private Date createTime;

    private Integer storeId;

    private String storeName;

    private Integer fromMemberId;

    private String fromMemberName;

    private Boolean isShow;

    private String remark;

    private String explain;

    private String images;

    public EvaluateGoods(Integer evaluateGoodsId, Integer orderId, String orderSn, Integer orderGoodsId, Integer goodsId, String goodsName, BigDecimal goodsPrice, String goodsImages, Integer scores, String content, Boolean isAnonymous, Date createTime, Integer storeId, String storeName, Integer fromMemberId, String fromMemberName, Boolean isShow, String remark, String explain, String images) {
        this.evaluateGoodsId = evaluateGoodsId;
        this.orderId = orderId;
        this.orderSn = orderSn;
        this.orderGoodsId = orderGoodsId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsImages = goodsImages;
        this.scores = scores;
        this.content = content;
        this.isAnonymous = isAnonymous;
        this.createTime = createTime;
        this.storeId = storeId;
        this.storeName = storeName;
        this.fromMemberId = fromMemberId;
        this.fromMemberName = fromMemberName;
        this.isShow = isShow;
        this.remark = remark;
        this.explain = explain;
        this.images = images;
    }

    public EvaluateGoods() {
        super();
    }

    public Integer getEvaluateGoodsId() {
        return evaluateGoodsId;
    }

    public void setEvaluateGoodsId(Integer evaluateGoodsId) {
        this.evaluateGoodsId = evaluateGoodsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
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

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(String goodsImages) {
        this.goodsImages = goodsImages == null ? null : goodsImages.trim();
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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

    public Integer getFromMemberId() {
        return fromMemberId;
    }

    public void setFromMemberId(Integer fromMemberId) {
        this.fromMemberId = fromMemberId;
    }

    public String getFromMemberName() {
        return fromMemberName;
    }

    public void setFromMemberName(String fromMemberName) {
        this.fromMemberName = fromMemberName == null ? null : fromMemberName.trim();
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }
}