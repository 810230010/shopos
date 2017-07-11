package com.wuliangit.shopos.dto;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/7/11.
 */
public class SimpleActivityDTO {
    private Integer activityId;
    private String activityTitle;
    private BigDecimal activityPrice;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public BigDecimal getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }
}
