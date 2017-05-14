package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.MemberAdviceMapper;
import com.wuliangit.shopos.entity.MemberAdvice;
import com.wuliangit.shopos.service.MemberAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/5/14.
 */

@Service
public class MemberAdviceServiceImpl implements MemberAdviceService {

    @Autowired
    private MemberAdviceMapper memberAdviceMapper;

    @Override
    public ArrayList<MemberAdvice> getMemberAdviceList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        PageHelper.startPage(page, pageSize);
        return memberAdviceMapper.queryMemberAdviceList(orderColumn, orderType, searchKey);
    }

    @Override
    public int updateAdviceLookStatus(Integer adviceId) {
        return memberAdviceMapper.updateAdviceLookStatus(adviceId);
    }

    @Override
    public int deleteAdvice(Integer adviceId) {
        return memberAdviceMapper.deleteByPrimaryKey(adviceId);
    }
}
