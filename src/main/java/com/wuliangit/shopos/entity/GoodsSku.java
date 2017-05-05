package com.wuliangit.shopos.entity;

import java.math.BigDecimal;

public class GoodsSku {
    private Integer goodsSkuId;

    private String skuValue;

    private BigDecimal skuPrice;

    private Integer skuStock;

    private Integer goodsId;

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public String getSkuValue() {
        return skuValue;
    }

    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue == null ? null : skuValue.trim();
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Integer getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(Integer skuStock) {
        this.skuStock = skuStock;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}