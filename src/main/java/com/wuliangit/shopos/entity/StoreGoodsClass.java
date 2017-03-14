package com.wuliangit.shopos.entity;

public class StoreGoodsClass {
    private Integer storeGoodsClassId;

    private String name;

    private Integer parentId;

    private Boolean state;

    private Integer sort;

    public Integer getStoreGoodsClassId() {
        return storeGoodsClassId;
    }

    public void setStoreGoodsClassId(Integer storeGoodsClassId) {
        this.storeGoodsClassId = storeGoodsClassId;
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