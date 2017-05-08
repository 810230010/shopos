package com.wuliangit.shopos.entity;

public class Area {
    private Integer areaId;

    private String name;

    private Integer parentId;

    private Integer sort;

    private Integer deep;

    private String region;

    public Area(Integer areaId, String name, Integer parentId, Integer sort, Integer deep, String region) {
        this.areaId = areaId;
        this.name = name;
        this.parentId = parentId;
        this.sort = sort;
        this.deep = deep;
        this.region = region;
    }

    public Area() {
        super();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }
}