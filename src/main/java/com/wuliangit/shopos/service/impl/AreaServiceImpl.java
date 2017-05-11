package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.AreaMapper;
import com.wuliangit.shopos.entity.Area;
import com.wuliangit.shopos.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nilme on 2017/5/6.
 */

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;


    @Override
    public List<Area> getArea(Integer parentId) {
        return areaMapper.getAreaByParentId(parentId);
    }
}
