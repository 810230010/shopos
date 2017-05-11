package com.wuliangit.shopos.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by nilme on 2017/5/11.
 */
public class ApiCartDTO {

    private Integer cartId;

    private Integer storeId;

    private String storeName;

    private Integer goodsSkuId;

    private Integer goodsId;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer goodsNum;

    private String goodsTitleImg;

    private boolean checked;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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
        this.storeName = storeName;
    }

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
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
        this.goodsName = goodsName;
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
        this.goodsTitleImg = goodsTitleImg;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
