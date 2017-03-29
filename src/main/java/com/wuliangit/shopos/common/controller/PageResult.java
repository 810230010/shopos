package com.wuliangit.shopos.common.controller;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by taoshanchang on 16/8/31.
 */
public class PageResult<T> extends HashMap<String, Object> {

    public final String DRAW = "draw";
    public final String RECORDS_TOTAL = "recordsTotal";
    public final String RECORDS_FILTERED = "recordsFiltered";
    public final String DATA = "data";

    public PageResult(List<T> list, int draw) {
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        this.put(DRAW, draw);
        this.put(RECORDS_TOTAL, pageInfo.getTotal());
        this.put(RECORDS_FILTERED, pageInfo.getTotal());
        this.put(DATA, pageInfo.getList());
    }
}
