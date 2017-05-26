package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.RefundMapper;
import com.wuliangit.shopos.dto.StoreRefundListDTO;
import com.wuliangit.shopos.entity.Refund;
import com.wuliangit.shopos.exception.BaseException;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.StoreRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pangweichao
 * @description 退换货业务层的实现
 * @create 2017-05-12 10:23
 **/
@Service
public class StoreRefundServiceImpl implements StoreRefundService {

    @Autowired
    private RefundMapper refundMapper;

    @Override
    public List<StoreRefundListDTO> getApplyRefundList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        StoreMin store = WebUtil.getCurrentStore();
        List<StoreRefundListDTO> storeRefundListDTOS = refundMapper.getApplyRefundList(store.getStoreId(),searchKey,orderColumn,orderType);
        return storeRefundListDTOS;
    }

    @Override
    public Integer checkRefundApply(Integer refundId, Boolean isPass) throws BaseException {
        Refund refund = refundMapper.selectByPrimaryKey(refundId);
        if (isPass){
            refund.setRefundState(POJOConstants.REFUND_STATE_CONSENT);
        }else{
            refund.setRefundState(POJOConstants.REFUND_STATE_NOT_CONSENT);
        }
        return refundMapper.updateByPrimaryKeySelective(refund);
    }

    @Override
    public List<StoreRefundListDTO> getSuccessRefundList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize, String type) {
        PageHelper.startPage(page,pageSize);
        StoreMin store = WebUtil.getCurrentStore();
        List<StoreRefundListDTO> storeRefundListDTOS = refundMapper.getSuccessRefundList(store.getStoreId(),searchKey,orderColumn,orderType,type);
        return storeRefundListDTOS;
    }

    @Override
    public Refund getRefundDetailInfo(Integer refundId) throws Exception {
        Refund refund = refundMapper.selectByPrimaryKey(refundId);
        if(refund == null){
            throw new BaseException("出错啦");
        }
        return refund;
    }
}
