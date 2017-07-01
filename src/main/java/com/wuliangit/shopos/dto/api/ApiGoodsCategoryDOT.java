package com.wuliangit.shopos.dto.api;

/**
 * Created by nilme on 2017/5/14.
 */
public class ApiGoodsCategoryDOT {

    private Integer goodsCategoryId;

    private String name;

    private String img;

    private String adImg;

    public String getAdImg() {
        return adImg;
    }

    public void setAdImg(String adImg) {
        this.adImg = adImg;
    }

    public Integer getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
