package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.dao.StoreAccountMapper;
import com.wuliangit.shopos.dao.StoreJoininMapper;
import com.wuliangit.shopos.dao.StoreMapper;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.entity.StoreAccount;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.service.StoreJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JangJanPing on 2017/4/27.
 */
@Service
public class StoreJoinServiceImpl implements StoreJoinService {
    @Autowired
    private StoreJoininMapper storeJoininMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private StoreAccountMapper storeAccountMapper;


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
    @Transactional
    public int passApplyForJoininStore(Integer memberId) {
        int i = storeJoininMapper.passStoreJoininApply(memberId);

        StoreJoinin storeJoinin = storeJoininMapper.getByMemberId(memberId);
        Store store = new Store();
        Member member = memberMapper.selectByPrimaryKey(memberId);

        store.setBindMemberId(member.getMemberId());
        store.setBindMemberUsername(member.getUsername());
        store.setName(storeJoinin.getStoreName());
        store.setType(storeJoinin.getType());
        store.setCreateTime(new Date());
        store.setPhone(member.getUsername());

        storeMapper.insertSelective(store);

        StoreAccount storeAccount = new StoreAccount();

        storeAccount.setStoreId(store.getStoreId());
        storeAccount.setFreezeBalance(new BigDecimal(0));
        storeAccount.setAvailableBalance(new BigDecimal(0));

        return storeAccountMapper.insertSelective(storeAccount);
    }

    @Override
    public StoreJoinin getStoreJoininDetail(Integer memberId) {
        return storeJoininMapper.queryStoreJoininByMemberId(memberId);
    }


}
