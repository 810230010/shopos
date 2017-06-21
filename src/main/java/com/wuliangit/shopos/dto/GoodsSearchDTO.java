package com.wuliangit.shopos.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

/**
 * Created by nilme on 2017/6/20.
 */
public class GoodsSearchDTO {

    /**
     * 页码
     */
    @DecimalMin(value ="1")
    private Integer page = 1;

    /**
     * 页大小
     */
    @Digits(integer = 1, fraction = 16)
    private Integer pageSize;

    /**
     * 搜索值
     */
    private String searchKey;

    /**
     * 排序类型 默认综合 salenum:销量, collect:搜藏数量, evaluationGoodStar:评价, click:点击量, evaluationCount:评价数，distance:距离
     */
    private String orderType = "salenum";

    /**
     * 经度
     * 当排序类型是 distance 时，需要传入
     */
    private Double lng;

    /**
     * 纬度
     * 当排序类型是 distance 时，需要传入
     */
    private Double lat;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
