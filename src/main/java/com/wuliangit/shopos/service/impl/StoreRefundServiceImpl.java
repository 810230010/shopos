package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.RefundMapper;
import com.wuliangit.shopos.dto.StoreRefundListDTO;
import com.wuliangit.shopos.exception.BaseException;
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
        List<StoreRefundListDTO> storeRefundListDTOS = refundMapper.getApplyRefundList(searchKey,orderColumn,orderType);
        return storeRefundListDTOS;
    }

    @Override
    public Integer checkRefundApply(Integer refundId, String sellerState) throws BaseException {
        Integer result = refundMapper.checkRefundApply(refundId,sellerState);
        if(result != 1){
            throw new BaseException("操作失败");
        }
        return result;
    }
}
