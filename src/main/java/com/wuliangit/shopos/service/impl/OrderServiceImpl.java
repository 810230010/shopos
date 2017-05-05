package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.*;
import com.wuliangit.shopos.entity.GoodsSku;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.entity.OrderGoods;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.model.GoodsWithoutBody;
import com.wuliangit.shopos.model.OrderInfo;
import com.wuliangit.shopos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

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


    @Override
    @Transactional
    public Order createOrder(OrderInfo[] orderInfos, Integer addressId, String orderFrom, BigDecimal goodsAmount) throws OrderException {

        Member member = WebUtil.getCurrentMember();

        BigDecimal trueGoodsAmount = new BigDecimal(0);

        Order order = new Order();

//        order.set
//        order.set
//        order.set
//        order.set
//        order.set
//        order.set
//        order.set
//        order.set
//        order.set
//        order.set

        ArrayList<OrderGoods> orderGoodses = new ArrayList<OrderGoods>();

        for (OrderInfo orderInfo : orderInfos) {
            GoodsSku goodsSku = goodsSkuMapper.selectByPrimaryKey(orderInfo.getGoodsSkuId());

            //检查商品库存
            if (goodsSku.getSkuStock() < 1) {
                throw new OrderException("商品已经售空");
            }
            //检查商品数量是否充足
            if (goodsSku.getSkuStock() < orderInfo.getGoodsNum()) {
                throw new OrderException("商品数量不足,缺货");
            }
            GoodsWithoutBody goodsWithoutBody = goodsMapper.selectGoodsWithoutBodyByPrimaryKey(goodsSku.getGoodsId());

            OrderGoods orderGoods = new OrderGoods();

            orderGoods.setGoodsId(goodsWithoutBody.getGoodsId());
            orderGoods.setCommission(goodsWithoutBody.getCommission());
            orderGoods.setGoodsImage(goodsWithoutBody.getTitleImg());
            orderGoods.setGoodsName(goodsWithoutBody.getName());
            orderGoods.setGoodsNum(orderInfo.getGoodsNum());
            orderGoods.setGoodsPayPrice(goodsSku.getSkuPrice());
            orderGoods.setGoodsType(goodsWithoutBody.getType());
            orderGoods.setMemberId(member.getMemberId());
            orderGoods.setStoreId(goodsWithoutBody.getStoreId());
            orderGoods.setSkuName(goodsSku.getSkuValue());
            orderGoods.setGoodsSkuId(goodsSku.getGoodsSkuId());

            trueGoodsAmount  = trueGoodsAmount.add(goodsSku.getSkuPrice());
        }

        return order;
    }
}
