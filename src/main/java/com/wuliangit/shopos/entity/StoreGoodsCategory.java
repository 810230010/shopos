package com.wuliangit.shopos.entity;

public class StoreGoodsCategory {
    private Integer storeGoodsCategoryId;

    private String name;

    private Integer parentId;

    private Boolean state;

    private Integer sort;

    public Integer getStoreGoodsCategoryId() {
        return storeGoodsCategoryId;
    }

    public void setStoreGoodsCategoryId(Integer storeGoodsCategoryId) {
        this.storeGoodsCategoryId = storeGoodsCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}