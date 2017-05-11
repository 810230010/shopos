package com.wuliangit.shopos.dto;

import java.math.BigDecimal;

/**
 * Created by pangweichao on 2017/5/6.
 */
public class StoreGoodsDetailDTO {

    private Integer goodsId;

    private String name;

    private String unit;

    private String adWord;

    private BigDecimal price;

    private String img;

    public StoreGoodsDetailDTO() {
    }

    /**
     * all
     * @param goodsId
     * @param name
     * @param unit
     * @param adWord
     * @param price
     * @param img
     */
    public StoreGoodsDetailDTO(Integer goodsId, String name, String unit, String adWord, BigDecimal price, String img) {
        this.goodsId = goodsId;
        this.name = name;
        this.unit = unit;
        this.adWord = adWord;
        this.price = price;
        this.img = img;
    }

    /**
     * 商品细节 用于商品设置中
     * @param goodsId
     * @param name
     * @param unit
     * @param adWord
     * @param price
     */
    public StoreGoodsDetailDTO(Integer goodsId, String name, String unit, String adWord, BigDecimal price) {
        this.goodsId = goodsId;
        this.name = name;
        this.unit = unit;
        this.adWord = adWord;
        this.price = price;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAdWord() {
        return adWord;
    }

    public void setAdWord(String adWord) {
        this.adWord = adWord;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
