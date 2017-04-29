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
    public ArrayList<StoreJoinin> getJoinStores(Integer page, Integer pageSize, String searchKey) {
        PageHelper.startPage(page, pageSize);
        return storeJoininMapper.queryJoinStores(searchKey);
    }


    @Override
    public int updateRejectedJoininStoreStatus(String joininMessage, Integer memberId) {
        return storeJoininMapper.rejectStoreJoininApply(joininMessage, memberId);
    }

    @Override
    public int passApplyForJoininStore(Integer memberId) {
        return storeJoininMapper.passStoreJoininApply(memberId);
    }

    @Override
    public StoreJoinin getStoreJoininDetail(Integer memberId) {
        return storeJoininMapper.queryStoreJoininByMemberId(memberId);
    }


}
