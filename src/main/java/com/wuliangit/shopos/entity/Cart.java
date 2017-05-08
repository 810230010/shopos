package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Cart {
    private Integer cartId;

    private Integer memberId;

    private Integer storeId;

    private String storeName;

    private Integer goodsId;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer goodsNum;

    private String goodsTitleImg;

    private Date createTime;

    public Cart(Integer cartId, Integer memberId, Integer storeId, String storeName, Integer goodsId, String goodsName, BigDecimal goodsPrice, Integer goodsNum, String goodsTitleImg, Date createTime) {
        this.cartId = cartId;
        this.memberId = memberId;
        this.storeId = storeId;
        this.storeName = storeName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsNum = goodsNum;
        this.goodsTitleImg = goodsTitleImg;
        this.createTime = createTime;
    }

    public Cart() {
        super();
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsTitleImg() {
        return goodsTitleImg;
    }

    public void setGoodsTitleImg(String goodsTitleImg) {
        this.goodsTitleImg = goodsTitleImg == null ? null : goodsTitleImg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}