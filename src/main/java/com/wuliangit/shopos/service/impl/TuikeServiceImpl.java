package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.dto.EarningsDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.TuikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nilme on 2017/3/27.
 */

@Service
public class TuikeServiceImpl implements TuikeService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public EarningsDTO getEarnings() {
        Member member = (Member) WebUtil.getSession().getAttribute(CoreConstants.SESSION_CURRENT_USER);
        Member member2 = memberMapper.selectByPrimaryKey(member.getMemberId());

        EarningsDTO earnings = new EarningsDTO();
        earnings.setAvailableBalance(member2.getAvailableBalance());
        earnings.setFreezeBalance(member2.getFreezeBalance());

        return earnings;
    }

    @Override
    public boolean earningsCash() {

        // TODO  推客提现

        return false;
    }
}
