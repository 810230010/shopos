package com.wuliangit.shopos.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JangJanPing on 2017/6/30.
 */
public class GoodsDetailDTO {
    private String name;
    private String unit;
    private String storeName;
    private String goodsCategory1;
    private String goodsCategory2;
    private String goodsCategory3;
    private String brandName;
    private BigDecimal price;
    private BigDecimal carriage;
    private Date sellTimeEnd;
    private Date sellTimeBegin;
    private Integer isPlatform;
    private Integer evaluationCount;
    private Integer evaluationGoodStar;
    private Integer commend;
    private String type;
    private Integer isNew;
    private String titleImg;
    private String images;
    private String goodsBody;
    private String[] imageSet;

    public String[] getImageSet() {
        return imageSet;
    }

    public void setImageSet(String[] imageSet) {
        this.imageSet = imageSet;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getGoodsCategory1() {
        return goodsCategory1;
    }

    public void setGoodsCategory1(String goodsCategory1) {
        this.goodsCategory1 = goodsCategory1;
    }

    public String getGoodsCategory2() {
        return goodsCategory2;
    }

    public void setGoodsCategory2(String goodsCategory2) {
        this.goodsCategory2 = goodsCategory2;
    }

    public String getGoodsCategory3() {
        return goodsCategory3;
    }

    public void setGoodsCategory3(String goodsCategory3) {
        this.goodsCategory3 = goodsCategory3;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCarriage() {
        return carriage;
    }

    public void setCarriage(BigDecimal carriage) {
        this.carriage = carriage;
    }

    public Date getSellTimeEnd() {
        return sellTimeEnd;
    }

    public void setSellTimeEnd(Date sellTimeEnd) {
        this.sellTimeEnd = sellTimeEnd;
    }

    public Date getSellTimeBegin() {
        return sellTimeBegin;
    }

    public void setSellTimeBegin(Date sellTimeBegin) {
        this.sellTimeBegin = sellTimeBegin;
    }

    public Integer getIsPlatform() {
        return isPlatform;
    }

    public void setIsPlatform(Integer isPlatform) {
        this.isPlatform = isPlatform;
    }

    public Integer getEvaluationCount() {
        return evaluationCount;
    }

    public void setEvaluationCount(Integer evaluationCount) {
        this.evaluationCount = evaluationCount;
    }

    public Integer getEvaluationGoodStar() {
        return evaluationGoodStar;
    }

    public void setEvaluationGoodStar(Integer evaluationGoodStar) {
        this.evaluationGoodStar = evaluationGoodStar;
    }

    public Integer getCommend() {
        return commend;
    }

    public void setCommend(Integer commend) {
        this.commend = commend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getGoodsBody() {
        return goodsBody;
    }

    public void setGoodsBody(String goodsBody) {
        this.goodsBody = goodsBody;
    }
}
