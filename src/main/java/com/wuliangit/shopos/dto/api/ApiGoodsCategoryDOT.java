package com.wuliangit.shopos.dto.api;

/**
 * Created by nilme on 2017/5/14.
 */
public class ApiGoodsCategoryDOT {

    private Integer goodsCategoryId;

    private String name;

    private String img;


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
