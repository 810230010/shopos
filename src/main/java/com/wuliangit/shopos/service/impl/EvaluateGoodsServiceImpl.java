package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.EvaluateGoodsMapper;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.dao.OrderGoodsMapper;
import com.wuliangit.shopos.dao.OrderMapper;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsDTO;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsListDTO;
import com.wuliangit.shopos.entity.EvaluateGoods;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.entity.OrderGoods;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.service.EvaluateGoodsService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private MemberMapper memberMapper;


    @Override
    public int createEvaluateGoods(ApiEvaluateGoodsDTO evaluateGoods) throws OptionException {

        Order order = orderMapper.selectByPrimaryKey(evaluateGoods.getOrderId());

        if (order == null) {
            throw new OptionException("订单不存在");
        }

        OrderGoods orderGoods = orderGoodsMapper.getByOrderIdAndGoodsId(evaluateGoods.getOrderId(), evaluateGoods.getGoodsId());

        if (orderGoods == null) {
            throw new OptionException("您没有购买过这个商品");
        }

        EvaluateGoods evaluate = mapper.map(evaluateGoods, EvaluateGoods.class);

        Member currentMember = WebUtil.getCurrentMember();

        evaluate.setCreateTime(new Date());
        evaluate.setIsShow(true);
        evaluate.setMemberId(currentMember.getMemberId());
        evaluate.setMemberName(currentMember.getNickname());
        evaluate.setStoreId(order.getStoreId());
        evaluate.setSkuValue(orderGoods.getSkuName());

        return evaluateGoodsMapper.insertSelective(evaluate);
    }

    @Override
    public List<ApiEvaluateGoodsListDTO> getEvaluateGoodsList(Integer page, Integer pageSize, Integer goodsId) {
        PageHelper.startPage(page, pageSize);
        List<EvaluateGoods> evaluateGoodsList = evaluateGoodsMapper.getEvaluateGoodsList(goodsId);

        List<ApiEvaluateGoodsListDTO> evaluateList = new ArrayList<>();

        for (EvaluateGoods evaluateGoods : evaluateGoodsList) {
            ApiEvaluateGoodsListDTO evaluate = mapper.map(evaluateGoods, ApiEvaluateGoodsListDTO.class);

            Member member = memberMapper.selectByPrimaryKey(evaluateGoods.getMemberId());

            if (evaluateGoods.getIsAnonymous()){
                evaluate.setMemberName(member.getNickname());
            }else{
                evaluate.setMemberName(member.getTruename());
            }
            evaluate.setPhoto(member.getPhoto());
            evaluateList.add(evaluate);
        }

        return evaluateList;
    }
}
