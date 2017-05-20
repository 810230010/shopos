package com.wuliangit.shopos.dto;

/**
 * Created by nilme on 2017/5/20.
 */
public class ApiEvaluateGoodsDTO {

    private Integer evaluateGoodsId;

    private Integer storeId;

    private Integer orderId;

    private Integer goodsId;

    private Integer star;

    private String content;

    private String images;

    private Boolean isAnonymous;

    public Integer getEvaluateGoodsId() {
        return evaluateGoodsId;
    }

    public void setEvaluateGoodsId(Integer evaluateGoodsId) {
        this.evaluateGoodsId = evaluateGoodsId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        isAnonymous = anonymous;
    }
}
