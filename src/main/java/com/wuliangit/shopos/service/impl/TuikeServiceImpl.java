package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.dao.GoodsMapper;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.dao.TuikeMapper;
import com.wuliangit.shopos.dto.TuikeCheckListDTO;
import com.wuliangit.shopos.dto.TuikePageListDTO;
import com.wuliangit.shopos.dto.api.ApiGoodsDTO;
import com.wuliangit.shopos.dto.api.ApiTuikeShareDataDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Tuike;
import com.wuliangit.shopos.dao.TuikeShareMapper;
import com.wuliangit.shopos.dto.api.ApiTuikeShareDTO;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.TuikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by nilme on 2017/3/27.
 */

@Service
public class TuikeServiceImpl implements TuikeService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private TuikeMapper tuikeMapper;

    @Autowired
    private TuikeShareMapper tuikeShareMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public boolean earningsCash() {

        // TODO  推客提现

        return false;
    }

    @Override
    public List<TuikeCheckListDTO> getCheckList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<TuikeCheckListDTO> result = tuikeMapper.getCheckList(searchKey,orderColumn,orderType);
        return result;
    }

    @Override
    @Transactional
    public Integer checkOperation(Integer memberId, String state) {
        if(state.equals("CHECKED")){
            String uuid = UUID.randomUUID().toString().replaceAll("_", "").substring(0,7);
            tuikeMapper.updateTuikeCode(memberId,uuid+memberId);
        }
        return tuikeMapper.checkOperation(memberId,state);
    }

    @Override
    public List<TuikePageListDTO> getTuikeList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<TuikePageListDTO> result = tuikeMapper.getTuikeList(searchKey,orderColumn,orderType);
        return result;
    }

    @Override
    public Integer forbiddenTuike(Integer tuikeId, String state) {
        return tuikeMapper.forbiddenTuike(tuikeId,state);
    }

    @Override
    public Tuike getTuikeByMemberId(Integer userId) {
        return tuikeMapper.getTuikeByMemberId(userId);
    }

    @Override
    public Tuike getTuikeInfo(Integer memberId) {
        return tuikeMapper.getTuikeInfo(memberId);
    }

    @Override
    public String getTuikeCode(Integer memberId) {
        return tuikeMapper.getTuikeCode(memberId);
    }

    @Override
    public List<ApiTuikeShareDataDTO> getShareInfo(Integer page, Integer pageSize, Integer tuikeId) {
        PageHelper.startPage(page, pageSize);
        List<ApiTuikeShareDataDTO> tuikeShareDTOS = tuikeShareMapper.getShareInfo(tuikeId);
        for(int i = 0 ; i<tuikeShareDTOS.size() ; i++){
            ApiGoodsDTO apiGoodsDTO = goodsMapper.apiGetGoodsDTOById(tuikeShareDTOS.get(i).getGoodsId());
            tuikeShareDTOS.get(i).setApiGoodsDTO(apiGoodsDTO);
        }
        return tuikeShareDTOS;
    }

    @Override
    public void createTuike(Member member) {
        Tuike tuike = new Tuike();
        tuike.setCreateTime(new Date());
        tuike.setState(POJOConstants.CHECKING);
        tuike.setMemberId(member.getMemberId());
        tuike.setUpdateTime(new Date());
        tuike.setCode(UUID.randomUUID().toString().substring(6)+member.getMemberId());

        tuikeMapper.insertSelective(tuike);
    }
}
