package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.dao.TuikeMapper;
import com.wuliangit.shopos.dto.ApiEarningsDTO;
import com.wuliangit.shopos.dto.TuikeMemberDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.TuikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nilme on 2017/3/27.
 */

@Service
public class TuikeServiceImpl implements TuikeService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private TuikeMapper tuikeMapper;

    @Override
    public ApiEarningsDTO getEarnings() {
        Member member = (Member) WebUtil.getSession().getAttribute(CoreConstants.SESSION_CURRENT_USER);
        Member member2 = memberMapper.selectByPrimaryKey(member.getMemberId());

        ApiEarningsDTO earnings = new ApiEarningsDTO();
        earnings.setAvailableBalance(member2.getAvailableBalance());
        earnings.setFreezeBalance(member2.getFreezeBalance());

        return earnings;
    }

    @Override
    public boolean earningsCash() {

        // TODO  推客提现

        return false;
    }

    @Override
    public List<TuikeMemberDTO> getCheckList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<TuikeMemberDTO> result = tuikeMapper.getCheckList(searchKey,orderColumn,orderType);
        return result;
    }

    @Override
    public Integer checkOperation(Integer memberId, String state) {
        return tuikeMapper.checkOperation(memberId,state);
    }
}
