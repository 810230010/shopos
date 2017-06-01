package com.wuliangit.shopos.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.OrderMapper;
import com.wuliangit.shopos.dao.RefundMapper;
import com.wuliangit.shopos.dao.TradeRefundMapper;
import com.wuliangit.shopos.dto.StoreRefundListDTO;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.entity.Refund;
import com.wuliangit.shopos.entity.TradeRefund;
import com.wuliangit.shopos.exception.BaseException;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.StoreRefundService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author pangweichao
 * @description 退换货业务层的实现
 * @create 2017-05-12 10:23
 **/
@Service
public class StoreRefundServiceImpl implements StoreRefundService {

    @Autowired
    private RefundMapper refundMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private TradeRefundMapper tradeRefundMapper;

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
    public List<StoreRefundListDTO> getSuccessRefundList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize, String refundType, String refundState) {
        PageHelper.startPage(page,pageSize);
        StoreMin store = WebUtil.getCurrentStore();
        List<StoreRefundListDTO> storeRefundListDTOS = refundMapper.getSuccessRefundList(store.getStoreId(),searchKey,orderColumn,orderType,refundType,refundState);
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

    @Override
    @Transactional
    public Integer checkReceiveGoods(Integer refundId) throws Exception {
        Refund refund = refundMapper.selectByPrimaryKey(refundId);
        Order order = orderMapper.selectByPrimaryKey(refund.getOrderId());

        if (!refund.getRefundState().equals(POJOConstants.REFUND_STATE_DELIVE)) {
            throw new OptionException("退款状态状态不符，不允许该操作");
        }

        AlipayClient alipayClient = AliPay.getAlipayClient();
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();

        AlipayTradeRefundModel model = new AlipayTradeRefundModel();

        String outTradeNo = order.getOutTradeNo();

        boolean isMergeOrder = false;

        if (!StringUtils.isEmpty(order.getOutTradeNoMerge())) {
            outTradeNo = order.getOutTradeNoMerge();
            isMergeOrder = true;
        }

        TradeRefund tradeRefund = new TradeRefund();
        tradeRefund.setOrderId(order.getOrderId());
        tradeRefund.setAmount(refund.getRefundAmount());
        tradeRefund.setPaymentCode(POJOConstants.ORDER_PAYMENT_ALIPAY);
        tradeRefund.setCreateTime(new Date());
        tradeRefund.setOutRequestNo(UUID.randomUUID().toString().replace("-", ""));
        tradeRefundMapper.insertSelective(tradeRefund);

        model.setOutTradeNo(outTradeNo);
        model.setTradeNo(order.getTradeNo());
        model.setRefundAmount(refund.getRefundAmount().toString());
        model.setRefundReason("退货退款");
        //为支付宝设置退款号
        model.setOutRequestNo(tradeRefund.getOutRequestNo());

        request.setBizModel(model);
        AlipayTradeRefundResponse response = alipayClient.execute(request);

        if (response.isSuccess()) {
            //更新订单退款状态
            if (refund.getRefundAmount().equals(order.getGoodsAmount())){//全部退款
                order.setRefundState(POJOConstants.ORDER_REFUND_STATE_ALL_REFUND);
            }else{//部分退款
                order.setRefundState(POJOConstants.ORDER_REFUND_STATE_PART_REFUND);
            }
            orderMapper.updateByPrimaryKeySelective(order);

            //更新退款记录状态
            refund.setRefundState(POJOConstants.REFUND_STATE_RECEIVE);
            return refundMapper.updateByPrimaryKeySelective(refund);
        } else {
            throw new OptionException("支付宝退款失败");
        }

    }

    @Override
    public List<StoreRefundListDTO> getRefundDoneList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        StoreMin store = WebUtil.getCurrentStore();
        List<StoreRefundListDTO> storeRefundListDTOS = refundMapper.getRefundDoneList(store.getStoreId(),searchKey,orderColumn,orderType);
        return storeRefundListDTOS;
    }
}
