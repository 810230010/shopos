package com.wuliangit.shopos.dto;

import java.math.BigDecimal;

/**
 * Created by nilme on 2017/3/30.
 */
public class ApiGoodsListDTO {

    private Integer goodsId;

    private String name;

    private String storeName;

    private BigDecimal price;

    private Long carriage;

    private String titleImg;

    private Integer salenum;

    private String area;

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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCarriage() {
        return carriage;
    }

    public void setCarriage(Long carriage) {
        this.carriage = carriage;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public Integer getSalenum() {
        return salenum;
    }

    public void setSalenum(Integer salenum) {
        this.salenum = salenum;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
