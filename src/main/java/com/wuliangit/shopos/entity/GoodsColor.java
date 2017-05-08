package com.wuliangit.shopos.entity;

import java.math.BigDecimal;

public class GoodsColor {
    private Integer goodsColorId;

    private Integer goodsId;

    private String colorImage;

    private BigDecimal colorPrice;

    private BigDecimal colorCommission;

    private BigDecimal commissionPercent;

    private String colorName;

    private String colorSort;

    public GoodsColor(Integer goodsColorId, Integer goodsId, String colorImage, BigDecimal colorPrice, BigDecimal colorCommission, BigDecimal commissionPercent, String colorName, String colorSort) {
        this.goodsColorId = goodsColorId;
        this.goodsId = goodsId;
        this.colorImage = colorImage;
        this.colorPrice = colorPrice;
        this.colorCommission = colorCommission;
        this.commissionPercent = commissionPercent;
        this.colorName = colorName;
        this.colorSort = colorSort;
    }

    public GoodsColor() {
        super();
    }

    public Integer getGoodsColorId() {
        return goodsColorId;
    }

    public void setGoodsColorId(Integer goodsColorId) {
        this.goodsColorId = goodsColorId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getColorImage() {
        return colorImage;
    }

    public void setColorImage(String colorImage) {
        this.colorImage = colorImage == null ? null : colorImage.trim();
    }

    public BigDecimal getColorPrice() {
        return colorPrice;
    }

    public void setColorPrice(BigDecimal colorPrice) {
        this.colorPrice = colorPrice;
    }

    public BigDecimal getColorCommission() {
        return colorCommission;
    }

    public void setColorCommission(BigDecimal colorCommission) {
        this.colorCommission = colorCommission;
    }

    public BigDecimal getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(BigDecimal commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName == null ? null : colorName.trim();
    }

    public String getColorSort() {
        return colorSort;
    }

    public void setColorSort(String colorSort) {
        this.colorSort = colorSort == null ? null : colorSort.trim();
    }
}