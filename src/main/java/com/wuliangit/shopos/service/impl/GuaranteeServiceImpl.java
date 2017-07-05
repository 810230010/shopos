package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.util.OrderUtil;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.GuaranteeOrderMapper;
import com.wuliangit.shopos.entity.GuaranteeOrder;
import com.wuliangit.shopos.service.GuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/4.
 */
@Service
public class GuaranteeServiceImpl implements GuaranteeService {
    @Autowired
    private GuaranteeOrderMapper guaranteeOrderMapper;
    @Override
    public int createGuaranteeOrder(GuaranteeOrder order) {
        return guaranteeOrderMapper.insertSelective(order);
    }

    @Override
    public GuaranteeOrder getGuaranteeOrderByOrderID(Integer orderId) {
        return guaranteeOrderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public GuaranteeOrder getGuaranteeOrderByOutTradeNo(String outTradeNo) {
        return guaranteeOrderMapper.selectGuaranteeOrderByOutTradeNo(outTradeNo);
    }

    @Override
    @Transactional
    public void updateGuaranteeOrder(GuaranteeOrder order) {
        guaranteeOrderMapper.updateByPrimaryKeySelective(order);
        guaranteeOrderMapper.updataStoreGuaranteePayedStatus(order.getStoreId());
    }

    @Override
    public String getCurrentStoreGuaranteeStatus() {
        Integer storeId = WebUtil.getCurrentStore().getStoreId();
        String guaranteeStatus = guaranteeOrderMapper.getGuaranteePayedStatus(storeId);
        return guaranteeStatus;
    }
}
