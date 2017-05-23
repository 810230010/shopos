package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * Created by nilme on 2017/5/20.
 */
public class ApiEvaluateGoodsListDTO {

    private Integer evaluateGoodsId;

    private Integer star;

    private String content;

    private String images;

    private String photo;

    private String memberName;

    private String skuValue;

    private Date createTime;

    public Integer getEvaluateGoodsId() {
        return evaluateGoodsId;
    }

    public void setEvaluateGoodsId(Integer evaluateGoodsId) {
        this.evaluateGoodsId = evaluateGoodsId;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSkuValue() {
        return skuValue;
    }

    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
