package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.StoreJoininMapper;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.service.StoreJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by JangJanPing on 2017/4/27.
 */
@Service
public class StoreJoinServiceImpl implements StoreJoinService {
    @Autowired
    private StoreJoininMapper storeJoininMapper;
    @Override
    /**
     * 查询申请成为店铺列表
     */
    public ArrayList<StoreJoinin> getJoinStores(Integer page, Integer pageSize, String searchKey, String orderColumn) {
        PageHelper.startPage(page, pageSize);
        return storeJoininMapper.queryJoinStores(searchKey, orderColumn);
    }
}
