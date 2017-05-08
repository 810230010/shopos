package com.wuliangit.shopos.entity;

public class StoreGoodsAd {
    private Integer storeGoodsAdId;

    private Integer goodsId;

    private Integer storeId;

    private String img;

    public StoreGoodsAd(Integer storeGoodsAdId, Integer goodsId, Integer storeId, String img) {
        this.storeGoodsAdId = storeGoodsAdId;
        this.goodsId = goodsId;
        this.storeId = storeId;
        this.img = img;
    }

    public StoreGoodsAd() {
        super();
    }

    public Integer getStoreGoodsAdId() {
        return storeGoodsAdId;
    }

    public void setStoreGoodsAdId(Integer storeGoodsAdId) {
        this.storeGoodsAdId = storeGoodsAdId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}