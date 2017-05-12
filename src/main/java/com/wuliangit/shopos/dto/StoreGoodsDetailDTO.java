package com.wuliangit.shopos.dto;

/**
 * Created by pangweichao on 2017/5/6.
 */
public class StoreGoodsDetailDTO {

    private Integer goodsId;

    private String name;

    private String img;

    public StoreGoodsDetailDTO(Integer goodsId, String name) {
        this.goodsId = goodsId;
        this.name = name;
    }

    public StoreGoodsDetailDTO(Integer goodsId, String name, String img) {
        this.goodsId = goodsId;
        this.name = name;
        this.img = img;
    }

    public StoreGoodsDetailDTO() {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
