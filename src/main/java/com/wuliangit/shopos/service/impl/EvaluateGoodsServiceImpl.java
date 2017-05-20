package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.EvaluateGoodsMapper;
import com.wuliangit.shopos.dao.OrderGoodsMapper;
import com.wuliangit.shopos.dao.OrderMapper;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsDTO;
import com.wuliangit.shopos.entity.EvaluateGoods;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.entity.OrderGoods;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.service.EvaluateGoodsService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by nilme on 2017/5/20.
 */

@Service
public class EvaluateGoodsServiceImpl implements EvaluateGoodsService {

    @Autowired
    private EvaluateGoodsMapper evaluateGoodsMapper;
    @Autowired
    private Mapper mapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;


    @Override
    public int createEvaluateGoods(ApiEvaluateGoodsDTO evaluateGoods) throws OptionException {

        Order order = orderMapper.selectByPrimaryKey(evaluateGoods.getOrderId());

        if (order == null){
            throw new OptionException("订单不存在");
        }

        OrderGoods orderGoods = orderGoodsMapper.getByOrderIdAndGoodsId(evaluateGoods.getOrderId(),evaluateGoods.getGoodsId());

        if (orderGoods == null){
            throw new OptionException("您没有购买过这个商品");
        }

        EvaluateGoods evaluate = mapper.map(evaluateGoods, EvaluateGoods.class);

        Member currentMember = WebUtil.getCurrentMember();

        evaluate.setCreateTime(new Date());
        evaluate.setIsShow(true);
        evaluate.setMemberId(currentMember.getMemberId());
        evaluate.setMemberName(currentMember.getNickname());
        evaluate.setStoreId(order.getStoreId());

        return evaluateGoodsMapper.insertSelective(evaluate);
    }
}
