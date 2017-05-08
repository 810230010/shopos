package com.wuliangit.shopos.entity;

public class Brand {
    private Integer brandId;

    private String name;

    private String initial;

    private String categoryName;

    private String pic;

    private Integer sort;

    private Boolean isRecommend;

    private Integer storeId;

    private String brandApply;

    private Integer goodsCategoryId;

    public Brand(Integer brandId, String name, String initial, String categoryName, String pic, Integer sort, Boolean isRecommend, Integer storeId, String brandApply, Integer goodsCategoryId) {
        this.brandId = brandId;
        this.name = name;
        this.initial = initial;
        this.categoryName = categoryName;
        this.pic = pic;
        this.sort = sort;
        this.isRecommend = isRecommend;
        this.storeId = storeId;
        this.brandApply = brandApply;
        this.goodsCategoryId = goodsCategoryId;
    }

    public Brand() {
        super();
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Boolean isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getBrandApply() {
        return brandApply;
    }

    public void setBrandApply(String brandApply) {
        this.brandApply = brandApply == null ? null : brandApply.trim();
    }

    public Integer getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }
}