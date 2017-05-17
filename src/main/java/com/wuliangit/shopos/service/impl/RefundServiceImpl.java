package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.RefundMapper;
import com.wuliangit.shopos.dto.ApiRefundDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nilme on 2017/5/17.
 */
@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundMapper refundMapper;


    @Override
    public List<ApiRefundDTO> apiGetRefundOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Member currentMember = WebUtil.getCurrentMember();
        List<ApiRefundDTO> refunds = refundMapper.apiGetRefunds(currentMember.getMemberId());
        return refunds;
    }
}
