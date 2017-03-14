package com.wuliangit.shopos.entity;

import java.math.BigDecimal;

public class StoreGrade {
    private Integer storeGradeId;

    private String name;

    private Integer goodsLimit;

    private Integer albumLimit;

    private Integer spaceLimit;

    private Integer templateNumber;

    private String template;

    private BigDecimal price;

    private String function;

    private Integer sort;

    private String description;

    public Integer getStoreGradeId() {
        return storeGradeId;
    }

    public void setStoreGradeId(Integer storeGradeId) {
        this.storeGradeId = storeGradeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGoodsLimit() {
        return goodsLimit;
    }

    public void setGoodsLimit(Integer goodsLimit) {
        this.goodsLimit = goodsLimit;
    }

    public Integer getAlbumLimit() {
        return albumLimit;
    }

    public void setAlbumLimit(Integer albumLimit) {
        this.albumLimit = albumLimit;
    }

    public Integer getSpaceLimit() {
        return spaceLimit;
    }

    public void setSpaceLimit(Integer spaceLimit) {
        this.spaceLimit = spaceLimit;
    }

    public Integer getTemplateNumber() {
        return templateNumber;
    }

    public void setTemplateNumber(Integer templateNumber) {
        this.templateNumber = templateNumber;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}