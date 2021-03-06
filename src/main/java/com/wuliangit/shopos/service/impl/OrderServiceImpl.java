package com.wuliangit.shopos.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.common.util.OrderUtil;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.*;
import com.wuliangit.shopos.dto.api.ApiOrderDTO;
import com.wuliangit.shopos.dto.api.ApiOrderGoodsDTO;
import com.wuliangit.shopos.dto.api.ApiSellerInfo;
import com.wuliangit.shopos.dto.StoreOrderListDTO;
import com.wuliangit.shopos.entity.*;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.model.*;
import com.wuliangit.shopos.service.CartService;
import com.wuliangit.shopos.service.OrderService;
import com.wuliangit.shopos.service.StoreService;
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
    @Autowired
    private StoreAccountMapper storeAccountMapper;
    @Autowired
    private StoreAccountLogMapper storeAccountLogMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private CartService cartService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Autowired
    private EvaluateGoodsMapper evaluateGoodsMapper;

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
        for (Map.Entry<Integer, List<OrderGoods>> entry : orderCreateTemp.entrySet()) {
            List<OrderGoods> orderGoodses = orderCreateTemp.get(entry.getKey());
            StoreMin storeMin = storeMapper.getStoreMinByStoreId(entry.getKey());

            Order order = new Order();
            order.setStoreId(entry.getKey());
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

                //删除购物车商品
                int res = cartService.deleteCartGoodsByGoodsId(orderGoods.getGoodsId());

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

        StoreMin store = WebUtil.getCurrentStore();

        List<StoreOrderListDTO> storeOrderListDTOS = orderMapper.getStoreOrderList(searchKey, orderColumn, orderType, state, store.getStoreId());
        return storeOrderListDTOS;
    }

    @Override
    public Order getOrderDetail(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<ApiOrderDTO> apiGetUnpayOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Member currentMember = WebUtil.getCurrentMember();
        List<ApiOrderDTO> orders = orderMapper.apiGetOrderByStateAndMemberId(POJOConstants.ORDER_STATE_INIT, currentMember.getMemberId());

        for (ApiOrderDTO order : orders) {
            order.setOrderGoodses(orderGoodsMapper.apiGetByOrderId(order.getOrderId()));
        }
        return orders;
    }

    @Override
    public List<ApiOrderDTO> apiGetPayedOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Member currentMember = WebUtil.getCurrentMember();
        List<ApiOrderDTO> orders = orderMapper.apiGetOrderByStateAndMemberId(POJOConstants.ORDER_STATE_PAYED, currentMember.getMemberId());

        for (ApiOrderDTO order : orders) {
            order.setOrderGoodses(orderGoodsMapper.apiGetByOrderId(order.getOrderId()));
        }
        return orders;
    }

    @Override
    public List<ApiOrderDTO> apiGetDelivedOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Member currentMember = WebUtil.getCurrentMember();
        List<ApiOrderDTO> orders = orderMapper.apiGetOrderByStateAndMemberId(POJOConstants.ORDER_STATE_DELIVE, currentMember.getMemberId());

        for (ApiOrderDTO order : orders) {
            order.setOrderGoodses(orderGoodsMapper.apiGetByOrderId(order.getOrderId()));
        }
        return orders;
    }

    @Override
    public List<ApiOrderDTO> apiGetUnEvaluateOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Member currentMember = WebUtil.getCurrentMember();
        List<ApiOrderDTO> orders = orderMapper.apiGetUnEvaluateOrderByMemberId(currentMember.getMemberId());

        for (ApiOrderDTO order : orders) {
            order.setOrderGoodses(orderGoodsMapper.apiGetByOrderId(order.getOrderId()));
        }

        return orders;
    }

    @Override
    public List<ApiOrderDTO> apiGetAllOrders(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
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

        order.setExpressCode(express.getExpressCode());
        order.setExpressName(express.getExpressName());
        order.setExpressNo(expressNo);
        order.setOrderState(POJOConstants.ORDER_STATE_DELIVE);
        order.setDeliverTime(new Date());

        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    @Transactional
    public int receive(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderState(POJOConstants.ORDER_STATE_END);
        List<OrderGoods> orderGoodss = orderGoodsMapper.getByOrderId(orderId);
        for (OrderGoods orderGoods : orderGoodss) {
            Goods goods = goodsMapper.selectByPrimaryKey(orderGoods.getGoodsId());
            goods.setSalenum(goods.getSalenum()+1);
            goodsMapper.updateByPrimaryKeySelective(goods);
        }

        //添加流水日志
        StoreAccountLog storeAccountLog = new StoreAccountLog();
        storeAccountLog.setOrderId(orderId);
        storeAccountLog.setCreateTime(new Date());
        storeAccountLog.setStoreId(order.getStoreId());
        storeAccountLog.setAmount(order.getOrderAmount());
        storeAccountLog.setType(POJOConstants.STORE_ACCOUNT_LOG_ORDER);
        storeAccountLogMapper.insertSelective(storeAccountLog);

        //修改店铺余额
        StoreAccount storeAccount = storeAccountMapper.getByStoreId(order.getStoreId());
        storeAccount.setAvailableBalance(storeAccount.getAvailableBalance().add(order.getOrderAmount()));
        storeAccountMapper.updateByPrimaryKeySelective(storeAccount);

        //更新店铺营业额
        storeMapper.updateTradingVolume(order.getStoreId(),order.getOrderAmount().add(storeMapper.getTradingVolume(order.getStoreId())));

        //修改店铺等级
        storeMapper.updateStoreGradeId(order.getStoreId(),storeMapper.getTradingVolume(order.getStoreId()).intValue()/CoreConstants.GRADE);

        //更新商户的商品描述度
        List<OrderGoods> goods = orderGoodsMapper.getByOrderId(order.getOrderId());
        Integer storeOrderAmount = storeMapper.getStoreOrderAmount(order.getStoreId());
        storeMapper.updateStoreOrderAmount(order.getStoreId(),goods.size());
        Integer storeOrderAmountNow = storeMapper.getStoreOrderAmount(order.getStoreId());
        Integer amount = 0;
        for(int i=0;i<goods.size();i++){
            amount += evaluateGoodsMapper.getOrderGoodsStar(orderId,goods.get(i).getGoodsId());
        }
        storeMapper.updateStoreDesccredit(order.getStoreId(),storeMapper.getDesccredit(order.getStoreId()).multiply(new BigDecimal(storeOrderAmount)).add(new BigDecimal(amount)).divide(new BigDecimal(storeOrderAmountNow)));

        //更新订单状态
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    @Transactional
    public int refund(Integer orderId, Integer goodsId, String refundType, String goodsState, String buyerMessage, String picsInfo) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        Member member = WebUtil.getCurrentMember();
        List<OrderGoods> orderGoodsList = orderGoodsMapper.getByOrderId(orderId);
        OrderGoods orderGoods = null;
        for (OrderGoods og : orderGoodsList) {
            if (og.getGoodsId().equals(goodsId)) {
                orderGoods = og;
            } else {
                continue;
            }
        }

        if (orderGoods == null) {
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
        refund.setSkuName(orderGoods.getSkuName());
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
        refund.setPicsInfo(picsInfo);

        if (!refund.getRefundType().equals(POJOConstants.APPLY_REFUND_MOMEY)){
            //设置退货收货地址
            Store store = storeMapper.selectByPrimaryKey(order.getStoreId());
            refund.setRefundAddress(store.getRefundAddress());
            refund.setRefundName(store.getRefundName());
            refund.setRefundPhone(store.getRefundPhone());
        }

        //更新订单状态
        order.setOrderState(POJOConstants.ORDER_STATE_REFUND);
        orderMapper.updateByPrimaryKeySelective(order);

        return refundMapper.insertSelective(refund);
    }

    @Override
    public int refundDelive(Integer refundId, String expressName, String expressNo, String expressCode) {
        Refund refund = refundMapper.selectByPrimaryKey(refundId);
        Store store = storeMapper.selectByPrimaryKey(refund.getStoreId());
        refund.setExpressNo(expressNo);
        refund.setExpressName(expressName);
        refund.setRefundPhone(store.getRefundPhone());
        refund.setRefundName(store.getRefundName());
        refund.setExpressCode(expressCode);
        refund.setRefundAddress(store.getRefundAddress());
        refund.setRefundTime(new Date());
        refund.setRefundState(POJOConstants.REFUND_STATE_DELIVE);
        return refundMapper.updateByPrimaryKeySelective(refund);
    }

    @Override
    public int cancelUnpay(Integer orderId) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (!order.getOrderState().equals(POJOConstants.ORDER_STATE_INIT)) {
            throw new OptionException("你已经付款，请申请退款");
        }
        order.setOrderState(POJOConstants.ORDER_STATE_CANCEL);

        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    @Transactional
    public int cancelPayed(Integer orderId) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        if (!order.getOrderState().equals(POJOConstants.ORDER_STATE_PAYED)) {
            throw new OptionException("订单状态不符，不允许该操作");
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


        model.setOutTradeNo(outTradeNo);
        model.setTradeNo(order.getTradeNo());
        model.setRefundAmount(order.getOrderAmount().toString());
        model.setRefundReason("正常退款");

        if (isMergeOrder) {
            TradeRefund tradeRefund = new TradeRefund();
            tradeRefund.setOrderId(order.getOrderId());
            tradeRefund.setAmount(order.getOrderAmount());
            tradeRefund.setPaymentCode(POJOConstants.ORDER_PAYMENT_ALIPAY);
            tradeRefund.setCreateTime(new Date());
            tradeRefund.setOutRequestNo(UUID.randomUUID().toString().replace("-", ""));
            tradeRefundMapper.insertSelective(tradeRefund);
            model.setOutRequestNo(tradeRefund.getOutRequestNo());
        }

        AlipayTradeRefundResponse response = alipayClient.execute(request);

        if (response.isSuccess()) {
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
        if (orderState.equals(POJOConstants.ORDER_STATE_PAYED) || orderState.equals(POJOConstants.ORDER_STATE_DELIVE)) {
            throw new OptionException("该订单状态不允许删除");
        }

        order.setDeleteState(POJOConstants.ORDER_DELETE_STATE_YES);
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    @Transactional
    public int storeRefund(Integer orderId) throws AlipayApiException, OptionException {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        Member member = memberMapper.selectByPrimaryKey(order.getMemberId());

        List<OrderGoods> orderGoodsList = orderGoodsMapper.getByOrderId(orderId);

        OrderGoods orderGoods = orderGoodsList.get(0);

        Refund refund = new Refund();
        refund.setOrderId(orderId);
        refund.setOrderOutTradeNo(order.getOutTradeNo());
        refund.setStoreId(order.getStoreId());
        refund.setMemberId(member.getMemberId());
        refund.setMemberUsername(member.getUsername());
        refund.setGoodsId(orderGoods.getGoodsId());
        refund.setGoodsName(orderGoods.getGoodsName());
        refund.setGoodsNum(orderGoods.getGoodsNum());
        refund.setSkuName(orderGoods.getSkuName());
        refund.setRefundAmount(order.getOrderAmount());
        refund.setGoodsImage(orderGoods.getGoodsImage());
        refund.setOrderGoodsType(orderGoods.getGoodsType());
        refund.setRefundType(POJOConstants.APPLY_STORE_REFUND);
        refund.setRefundState(POJOConstants.REFUND_STATE_RECEIVE);
        refund.setIsLock(false);
        refund.setGoodsState("NOT_DELIVE");
        refund.setCreateTime(new Date());
        refund.setBuyerMessage("");
        refund.setPicsInfo("");

        //先添加退款记录
        refundMapper.insertSelective(refund);

        //退款操作
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
            order.setOrderState(POJOConstants.ORDER_STATE_REFUND);
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
    public int getGoodsOrderCount(Integer goodsId) {
        return orderGoodsMapper.getGoodsOrderCount(goodsId);
    }

    @Override
    public List<StoreOrderListDTO> apiGetStoreOrderList(Integer page, Integer pageSize, String state) {
        PageHelper.startPage(page, pageSize);

        ApiSellerInfo sellerInfo = storeService.getSellerInfo();

        List<StoreOrderListDTO> storeOrderListDTOS = orderMapper.apiGetStoreOrderList(state, sellerInfo.getStoreId());
        return storeOrderListDTOS;
    }

    @Override
    public int apiAddExpressInfo(String expressName, String expressCode, String expressNo, Integer orderId) throws OptionException {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        ApiSellerInfo sellerInfo = storeService.getSellerInfo();

        if (sellerInfo.getStoreId().equals(order.getStoreId())){
            order.setExpressCode(expressCode);
            order.setExpressName(expressName);
            order.setExpressNo(expressNo);
            order.setOrderState(POJOConstants.ORDER_STATE_DELIVE);
            order.setDeliverTime(new Date());

            return orderMapper.updateByPrimaryKeySelective(order);
        }else{
            throw new OptionException("该订单不属于您！");
        }
    }

    @Override
    public List<StoreOrderListDTO> getAdminOrderList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize, String state) {
        PageHelper.startPage(page, pageSize);

        List<StoreOrderListDTO> storeOrderListDTOS = orderMapper.getAdminOrderList(searchKey, orderColumn, orderType, state);
        return storeOrderListDTOS;
    }
}
