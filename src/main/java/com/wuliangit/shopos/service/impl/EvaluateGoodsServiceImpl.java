package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.EvaluateGoodsMapper;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.dao.OrderGoodsMapper;
import com.wuliangit.shopos.dao.OrderMapper;
import com.wuliangit.shopos.dto.api.ApiEvaluateGoodsDTO;
import com.wuliangit.shopos.dto.api.ApiEvaluateGoodsListDTO;
import com.wuliangit.shopos.dto.EvaluateGoodsListDTO;
import com.wuliangit.shopos.dto.StoreEvaluateGoodsDetailDTO;
import com.wuliangit.shopos.entity.EvaluateGoods;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.entity.OrderGoods;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.service.EvaluateGoodsService;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public int createEvaluateGoods(List<ApiEvaluateGoodsDTO> evaluateGoodses,Integer orderId) throws OptionException {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        for (ApiEvaluateGoodsDTO evaluateGoods : evaluateGoodses) {
            if (order == null) {
                throw new OptionException("订单不存在");
            }
            OrderGoods orderGoods = orderGoodsMapper.getByOrderIdAndGoodsId(orderId, evaluateGoods.getGoodsId());
            if (orderGoods == null) {
                throw new OptionException("您没有购买过这个商品");
            }
            EvaluateGoods evaluate = mapper.map(evaluateGoods, EvaluateGoods.class);

            Member currentMember = WebUtil.getCurrentMember();

            if(StringUtils.isEmpty(evaluate.getContent())){
                evaluate.setContent("该用户没有评价");
            }
            evaluate.setCreateTime(new Date());
            evaluate.setIsShow(true);
            evaluate.setGoodsName(orderGoods.getGoodsName());
            evaluate.setMemberId(currentMember.getMemberId());
            evaluate.setMemberUsername(currentMember.getNickname());
            evaluate.setStoreId(order.getStoreId());
            evaluate.setSkuValue(orderGoods.getSkuName());
            evaluate.setOrderId(orderId);
            evaluateGoodsMapper.insertSelective(evaluate);
        }

        order.setMemberEvaluationState(POJOConstants.ORDER_EVALUATION_STATE_YES);
        return orderMapper.updateByPrimaryKeySelective(order);

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

    @Override
    public List<EvaluateGoodsListDTO> getEvaluateGoodsListInfo(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize, Integer storeId) {
        PageHelper.startPage(page,pageSize);
        List<EvaluateGoodsListDTO> result = evaluateGoodsMapper.getEvaluateGoodsListInfo(searchKey,orderColumn,orderType,storeId);
        return result;
    }

    @Override
    public StoreEvaluateGoodsDetailDTO getEvaluateGoodsDetail(Integer evaluateGoodsId) {
        return evaluateGoodsMapper.getEvaluateGoodsDetail(evaluateGoodsId);
    }
}
