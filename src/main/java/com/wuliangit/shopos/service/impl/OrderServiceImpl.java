package com.wuliangit.shopos.service.impl;

import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.*;
import com.wuliangit.shopos.entity.*;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.model.GoodsWithoutBody;
import com.wuliangit.shopos.model.OrderGoodsNum;
import com.wuliangit.shopos.model.OrderGoodsNum1;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by nilme on 2017/5/5.
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderCommonMapper orderCommonMapper;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private StoreMapper storeMapper;


    @Override
    @Transactional
    public AlipayTradeAppPayModel createOrder(List<OrderGoodsNum1> orderInfos, Integer addressId, String orderFrom, BigDecimal goodsAmount) throws OrderException {
        Member member = WebUtil.getCurrentMember();

        String outTradeNo = UUID.randomUUID().toString().replaceAll("-", "");

        BigDecimal totalAmount = new BigDecimal(0);

        for (OrderGoodsNum1 orderInfo : orderInfos) {
            ArrayList<OrderGoods> orderGoodses = new ArrayList<OrderGoods>();

            StoreMin storeMin = storeMapper.getStoreMinByStoreId(orderInfo.getStoreId());

            //商品总价
            BigDecimal trueGoodsAmount = new BigDecimal(0);
            //订单总价
            BigDecimal trueOrderAmount = new BigDecimal(0);
            //最贵邮费
            BigDecimal carriage = new BigDecimal(0);

            Order order = new Order();
            order.setStoreId(orderInfo.getStoreId());
            order.setMemberId(member.getMemberId());
            order.setMemberEmail(member.getEmail());
            order.setMemberName(member.getNikename());
            order.setCreateTime(new Date());
            order.setDeleteState(POJOConstants.ORDER_DELETE_STATE_NO);
            order.setEvaluationState(POJOConstants.ORDER_EVALUATION_STATE_NO);
            order.setIsLock(false);
            order.setOutTradeNo(outTradeNo);
            order.setOrderFrom(orderFrom);
            order.setRefundState(POJOConstants.ORDER_REFUND_STATE_NO_REFUND);
            order.setOrderState(POJOConstants.ORDER_STATE_INIT);
            order.setStoreName(storeMin.getName());


            List<OrderGoodsNum> orderGoodsNumList = orderInfo.getOrderGoodsNumList();

            for (OrderGoodsNum orderGoodsNum : orderGoodsNumList) {
                GoodsSku goodsSku = goodsSkuMapper.selectByPrimaryKey(orderGoodsNum.getGoodsSkuId());

                //检查商品库存
                if (goodsSku.getSkuStock() < 1) {
                    throw new OrderException("商品已经售空");
                }
                //检查商品数量是否充足
                if (goodsSku.getSkuStock() < orderGoodsNum.getGoodsNum()) {
                    throw new OrderException("商品数量不足,缺货");
                }
                GoodsWithoutBody goodsWithoutBody = goodsMapper.selectGoodsWithoutBodyByPrimaryKey(goodsSku.getGoodsId());

                OrderGoods orderGoods = new OrderGoods();

                orderGoods.setGoodsId(goodsWithoutBody.getGoodsId());
                orderGoods.setCommission(goodsWithoutBody.getCommission());
                orderGoods.setGoodsImage(goodsWithoutBody.getTitleImg());
                orderGoods.setGoodsName(goodsWithoutBody.getName());
                orderGoods.setGoodsNum(orderGoodsNum.getGoodsNum());
                orderGoods.setGoodsPayPrice(goodsSku.getSkuPrice());
                orderGoods.setGoodsType(goodsWithoutBody.getType());
                orderGoods.setMemberId(member.getMemberId());
                orderGoods.setStoreId(goodsWithoutBody.getStoreId());
                orderGoods.setSkuName(goodsSku.getSkuValue());
                orderGoods.setGoodsSkuId(goodsSku.getGoodsSkuId());

                trueGoodsAmount = trueGoodsAmount.add(goodsSku.getSkuPrice());

                if (carriage.compareTo(goodsWithoutBody.getCarriage()) >= 0) {
                    carriage = goodsWithoutBody.getCarriage();
                }

                orderGoodses.add(orderGoods);
            }

            order.setGoodsAmount(trueGoodsAmount);
            order.setOrderAmount(trueOrderAmount.add(carriage));
            order.setCarriage(carriage);

            totalAmount = totalAmount.add(order.getOrderAmount());

            orderMapper.insertSelective(order);

            for (OrderGoods orderGoods : orderGoodses) {
                orderGoods.setOrderId(order.getOrderId());
                orderGoodsMapper.insertSelective(orderGoods);
            }
        }

        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

        if (orderInfos.size() > 1) {
            model.setBody("合并订单");
        } else {
            model.setBody("合并订单");
        }

        model.setSubject("商品支付");
        model.setOutTradeNo(outTradeNo);
        model.setTimeoutExpress("30m");
        model.setTotalAmount(totalAmount.toString());
        model.setProductCode(AliPay.PRODUCTCODE);
        return model;
    }
}
