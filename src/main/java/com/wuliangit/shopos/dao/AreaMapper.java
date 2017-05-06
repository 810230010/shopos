package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Area;

import java.util.List;

public interface AreaMapper extends BaseMapper<Area, Integer> {

    /**
     * 获取地址选择列表
     * @param parentId
     * @return
     */
    List<Area> getAreaByParentId(Integer parentId);
}