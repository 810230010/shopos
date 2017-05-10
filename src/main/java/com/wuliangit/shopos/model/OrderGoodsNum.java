package com.wuliangit.shopos.model;

/**
 * Created by nilme on 2017/5/5.
 */
public class OrderGoodsNum {

    private Integer goodsSkuId;

    private Integer goodsNum;

    private Integer goodsId;

    public OrderGoodsNum() {
    }

    public OrderGoodsNum(Integer goodsSkuId, Integer goodsNum, Integer goodsId) {
        this.goodsSkuId = goodsSkuId;
        this.goodsNum = goodsNum;
        this.goodsId = goodsId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

}
