package com.wuliangit.shopos.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.common.util.OrderUtil;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.*;
import com.wuliangit.shopos.dto.ApiOrderDTO;
import com.wuliangit.shopos.dto.ApiOrderGoodsDTO;
import com.wuliangit.shopos.dto.StoreOrderListDTO;
import com.wuliangit.shopos.entity.*;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.model.*;
import com.wuliangit.shopos.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by nilme on 2017/5/5.
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Autowired
    private GoodsSkuMapper goodsSkuMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ExpressMapper expressMapper;
    @Autowired
    private RefundMapper refundMapper;
    @Autowired
    private TradeRefundMapper tradeRefundMapper;


    @Override
    @Transactional
    public List<Order> ApiCreateOrder(List<OrderGoodsInfo> orderGoodsInfoList, Integer addressId, String orderFrom, String orderMessage) throws OrderException {
        //当前用户
        Member member = WebUtil.getCurrentMember();
        //邮寄地址
        Address address = addressMapper.selectByPrimaryKey(addressId);
        //临时存放商品信息
        Map<Integer, List<OrderGoods>> orderCreateTemp = new HashMap<>();
        //返回订单列表
        List<Order> orders = new ArrayList<>();

        //合成预处理数据
        for (OrderGoodsInfo orderGoodsInfo : orderGoodsInfoList) {
            GoodsSku goodsSku = goodsSkuMapper.selectByPrimaryKey(orderGoodsInfo.getGoodsSkuId());

            //检查商品库存
            if (goodsSku.getSkuStock() < 1) {
                throw new OrderException("商品已经售空");
            }
            //检查商品数量是否充足
            if (goodsSku.getSkuStock() < orderGoodsInfo.getGoodsNum()) {
                throw new OrderException("商品数量不足,缺货");
            }

            GoodsWithoutBody goodsWithoutBody = goodsMapper.selectGoodsWithoutBodyByPrimaryKey(goodsSku.getGoodsId());

            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setGoodsId(goodsWithoutBody.getGoodsId());
            orderGoods.setMemberId(member.getMemberId());
            orderGoods.setGoodsSkuId(goodsSku.getGoodsSkuId());
            orderGoods.setSkuName(goodsSku.getSkuValue());
            orderGoods.setStoreId(goodsWithoutBody.getStoreId());
            orderGoods.setGoodsImage(goodsWithoutBody.getTitleImg());
            orderGoods.setGoodsType(goodsWithoutBody.getType());
            orderGoods.setGoodsName(goodsWithoutBody.getName());
            orderGoods.setGoodsNum(orderGoodsInfo.getGoodsNum());
            orderGoods.setCommission(goodsWithoutBody.getCommission());
            orderGoods.setGoodsPayPrice(goodsSku.getSkuPrice());
            orderGoods.setCarriage(goodsWithoutBody.getCarriage());

            List<OrderGoods> goodsGoodsSkuMap = orderCreateTemp.get(goodsWithoutBody.getStoreId());

            if (goodsGoodsSkuMap == null) {
                List<OrderGoods> orderGoodses = new ArrayList<>();
                orderGoodses.add(orderGoods);
                orderCreateTemp.put(goodsWithoutBody.getStoreId(), orderGoodses);
            } else {
                goodsGoodsSkuMap.add(orderGoods);
            }

            goodsSku.setSkuStock(goodsSku.getSkuStock() - orderGoodsInfo.getGoodsNum());
            goodsSkuMapper.updateByPrimaryKeySelective(goodsSku);
        }

        //生成订单
        for (Integer integer : orderCreateTemp.keySet()) {
            List<OrderGoods> orderGoodses = orderCreateTemp.get(integer);
            StoreMin storeMin = storeMapper.getStoreMinByStoreId(integer);

            Order order = new Order();
            order.setStoreId(integer);
            order.setMemberId(member.getMemberId());
            order.setMemberEmail(member.getEmail());
            order.setMemberName(member.getNickname());
            order.setCreateTime(new Date());
            order.setDeleteState(POJOConstants.ORDER_DELETE_STATE_NO);
            order.setMemberEvaluationState(POJOConstants.ORDER_EVALUATION_STATE_NO);
            order.setSellerEvaluationState(POJOConstants.ORDER_EVALUATION_STATE_NO);
            order.setIsLock(false);
            order.setOrderFrom(orderFrom);
            order.setRefundState(POJOConstants.ORDER_REFUND_STATE_NO_REFUND);
            order.setOrderState(POJOConstants.ORDER_STATE_INIT);
            order.setStoreName(storeMin.getName());
            order.setOrderMessage(orderMessage);
            //设置订单id
            order.setOutTradeNo(OrderUtil.makeOrderId());

            //设置收件人信息
            order.setReciverName(address.getReciverName());
            order.setReciverAddress(address.getAreaInfo());
            order.setReciverPhone(address.getMobPhone());

            //设置订单价格
            //商品总价
            BigDecimal goodsAmount = new BigDecimal(0);
            //最贵邮费
            BigDecimal carriage = new BigDecimal(0);
            for (OrderGoods orderGoods : orderGoodses) {
                //计算商品总价
                goodsAmount = goodsAmount.add(orderGoods.getGoodsPayPrice().multiply(new BigDecimal(orderGoods.getGoodsNum())));
                if (orderGoods.getCarriage().compareTo(carriage) > 0) {
                    //取最大邮费
                    carriage = orderGoods.getCarriage();
                }
            }
            order.setGoodsAmount(goodsAmount);
            order.setCarriageAmount(carriage);
            order.setOrderAmount(goodsAmount.add(carriage));

            orderMapper.insertSelective(order);
            orders.add(order);

            for (OrderGoods orderGoods : orderGoodses) {
                orderGoods.setOrderId(order.getOrderId());
                orderGoodsMapper.insertSelective(orderGoods);
            }
        }

        return orders;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public List<Order> getOrderByOutTradeNoMerge(String outTradeNo) {
        return orderMapper.getOrderByOutTradeNoMerge(outTradeNo);
    }

    @Override
    public Order getOrderByOutTradeNo(String outTradeNo) {
        return orderMapper.getOrderByOutTradeNo(outTradeNo);
    }

    @Override
    public List<StoreOrderListDTO> getStoreOrderList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize, String state) {
        PageHelper.startPage(page, pageSize);
        List<StoreOrderListDTO> storeOrderListDTOS = orderMapper.getStoreOrderList(searchKey, orderColumn, orderType, state);
        return storeOrderListDTOS;
    }

    @Override
    public Order getOrderDetail(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<ApiOrderDTO> apiGetUnpayOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Member currentMember = WebUtil.getCurrentMember();
        List<ApiOrderDTO> orders = orderMapper.apiGetOrderByStateAndMemberId(POJOConstants.ORDER_STATE_INIT, currentMember.getMemberId());

        for (ApiOrderDTO order : orders) {
            order.setOrderGoodses(orderGoodsMapper.apiGetByOrderId(order.getOrderId()));
        }
        return orders;
    }

    @Override
    public List<ApiOrderDTO> apiGetPayedOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Member currentMember = WebUtil.getCurrentMember();
        List<ApiOrderDTO> orders = orderMapper.apiGetOrderByStateAndMemberId(POJOConstants.ORDER_STATE_PAYED, currentMember.getMemberId());

        for (ApiOrderDTO order : orders) {
            order.setOrderGoodses(orderGoodsMapper.apiGetByOrderId(order.getOrderId()));
        }
        return orders;
    }

    @Override
    public List<ApiOrderDTO> apiGetDelivedOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Member currentMember = WebUtil.getCurrentMember();
        List<ApiOrderDTO> orders = orderMapper.apiGetOrderByStateAndMemberId(POJOConstants.ORDER_STATE_DELIVE, currentMember.getMemberId());

        for (ApiOrderDTO order : orders) {
            order.setOrderGoodses(orderGoodsMapper.apiGetByOrderId(order.getOrderId()));
        }
        return orders;
    }

    @Override
    public List<ApiOrderDTO> apiGetUnEvaluateOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Member currentMember = WebUtil.getCurrentMember();
        List<ApiOrderDTO> orders = orderMapper.apiGetUnEvaluateOrderByMemberId(currentMember.getMemberId());

        for (ApiOrderDTO order : orders) {
            order.setOrderGoodses(orderGoodsMapper.apiGetByOrderId(order.getOrderId()));
        }

        return orders;
    }

    @Override
    public List<ApiOrderDTO> apiGetAllOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Member currentMember = WebUtil.getCurrentMember();
        List<ApiOrderDTO> orders = orderMapper.apiGetOrderByMemberId(currentMember.getMemberId());

        for (ApiOrderDTO order : orders) {
            order.setOrderGoodses(orderGoodsMapper.apiGetByOrderId(order.getOrderId()));
        }
        return orders;
    }

    @Override
    public List<ApiOrderGoodsDTO> getOrderDetailGoods(Integer orderId) {
        return orderGoodsMapper.apiGetByOrderId(orderId);
    }

    @Override
    public int addExpressInfo(Integer expressId, String expressNo, Integer orderId) {
        Express express = expressMapper.selectByPrimaryKey(expressId);
        Order order = orderMapper.selectByPrimaryKey(orderId);

        order.setExpressName(express.getExpressName()+"/"+express.getExpressCode());
        order.setExpressNo(expressNo);
        order.setOrderState(POJOConstants.ORDER_STATE_DELIVE);
        order.setDeliverTime(new Date());

        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int receive(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderState(POJOConstants.ORDER_STATE_RECEIVE);
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int refund(Integer orderId, Integer goodsId, String refundType, String goodsState, String buyerMessage) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        Member member = WebUtil.getCurrentMember();
        List<OrderGoods> orderGoodsList = orderGoodsMapper.getByOrderId(orderId);
        OrderGoods orderGoods = null;
        for (OrderGoods og : orderGoodsList) {
            if (og.getGoodsId().equals(goodsId)){
                orderGoods = og;
            }else{
                continue;
            }
        }

        if (orderGoods == null){
            throw new OptionException("您没有购买过这个商品");
        }

        Refund refund = new Refund();
        refund.setOrderId(orderId);
        refund.setOrderOutTradeNo(order.getOutTradeNo());
        refund.setStoreId(order.getStoreId());
        refund.setMemberId(member.getMemberId());
        refund.setMemberUsername(member.getUsername());
        refund.setGoodsId(orderGoods.getGoodsId());
        refund.setGoodsName(orderGoods.getGoodsName());
        refund.setGoodsNum(orderGoods.getGoodsNum());
        refund.setRefundAmount(orderGoods.getGoodsPayPrice().multiply(new BigDecimal(orderGoods.getGoodsNum())));
        refund.setGoodsImage(orderGoods.getGoodsImage());
        refund.setOrderGoodsType(orderGoods.getGoodsType());
        refund.setRefundType(POJOConstants.APPLY_REFUND_ALL);
        refund.setRefundType(refundType);
        refund.setRefundState(POJOConstants.REFUND_STATE_CHECKING);
        refund.setIsLock(false);
        refund.setGoodsState(goodsState);
        refund.setCreateTime(new Date());
        refund.setBuyerMessage(buyerMessage);

        return refundMapper.insertSelective(refund);
    }

    @Override
    public int refundDelive(Integer refundId, String expressName, String expressNo) {
        Refund refund = refundMapper.selectByPrimaryKey(refundId);
        refund.setExpressNo(expressNo);
        refund.setExpressName(expressName);
        return refundMapper.updateByPrimaryKeySelective(refund);
    }

    @Override
    public int cancelUnpay(Integer orderId) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(!order.getOrderState().equals(POJOConstants.ORDER_STATE_INIT)){
            throw new OptionException("你已经付款，请申请退款");
        }
        order.setOrderState(POJOConstants.ORDER_STATE_CANCEL);

        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    @Transactional
    public int cancelPayed(Integer orderId) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        if(!order.getOrderState().equals(POJOConstants.ORDER_STATE_PAYED)){
            throw new OptionException("订单状态不符，不允许该操作");
        }

        AlipayClient alipayClient = AliPay.getAlipayClient();
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();

        AlipayTradeRefundModel model = new AlipayTradeRefundModel();

        String outTradeNo = order.getOutTradeNo();

        boolean isMergeOrder = false;

        if (!StringUtils.isEmpty(order.getOutTradeNoMerge())){
            outTradeNo = order.getOutTradeNoMerge();
            isMergeOrder = true;
        }


        model.setOutTradeNo(outTradeNo);
        model.setTradeNo(order.getTradeNo());
        model.setRefundAmount(order.getOrderAmount().toString());
        model.setRefundReason("正常退款");

        if(isMergeOrder){
            TradeRefund tradeRefund = new TradeRefund();
            tradeRefund.setOrderId(order.getOrderId());
            tradeRefund.setAmount(order.getOrderAmount());
            tradeRefund.setPaymentCode(POJOConstants.ORDER_PAYMENT_ALIPAY);
            tradeRefund.setCreateTime(new Date());
            tradeRefund.setOutRequestNo(UUID.randomUUID().toString().replace("-",""));
            tradeRefundMapper.insertSelective(tradeRefund);
            model.setOutRequestNo(tradeRefund.getOutRequestNo());
        }

        AlipayTradeRefundResponse response = alipayClient.execute(request);

        if(response.isSuccess()){
            order.setOrderState(POJOConstants.ORDER_STATE_CANCEL);
            order.setRefundState(POJOConstants.ORDER_REFUND_STATE_ALL_REFUND);
            return orderMapper.updateByPrimaryKeySelective(order);
        } else {
            throw new OptionException("支付宝退款失败");
        }

    }

    @Override
    public int apiDelete(Integer orderId) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        String orderState = order.getOrderState();
        if (orderState.equals(POJOConstants.ORDER_STATE_PAYED)||orderState.equals(POJOConstants.ORDER_STATE_DELIVE)){
            throw new OptionException("该订单状态不允许删除");
        }

        order.setDeleteState(POJOConstants.ORDER_DELETE_STATE_YES);
        return orderMapper.updateByPrimaryKeySelective(order);
    }
}
