package com.wuliangit.shopos.dto;

/**
 * Created by wuliang01 on 2017/7/10.
 */
public class ActivityCheckGoodsDTO {

    private Integer goodsId;

    private String name;

    private String storeName;

    private Long activityPrice;

    private String activityTitle;

    public ActivityCheckGoodsDTO() {
    }

    public ActivityCheckGoodsDTO(Integer goodsId, String name, String storeName, Long activityPrice, String activityTitle) {
        this.goodsId = goodsId;
        this.name = name;
        this.storeName = storeName;
        this.activityPrice = activityPrice;
        this.activityTitle = activityTitle;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(Long activityPrice) {
        this.activityPrice = activityPrice;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }
}
