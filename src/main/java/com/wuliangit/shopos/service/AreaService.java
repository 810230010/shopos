package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Area;

import java.util.List;

/**
 * Created by nilme on 2017/5/6.
 */
public interface AreaService {

    /**
     * 获取地址选择列表
     * @param parentId
     * @return
     */
    List<Area> getArea(Integer parentId);
}
