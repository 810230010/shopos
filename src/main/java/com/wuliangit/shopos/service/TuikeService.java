package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.api.ApiEarningsDTO;
import com.wuliangit.shopos.dto.TuikeCheckListDTO;
import com.wuliangit.shopos.dto.TuikePageListDTO;

import java.util.List;

/**
 * Created by nilme on 2017/3/27.
 */
public interface TuikeService {

    /**
     * 获取推客收益
     * @return
     */
    ApiEarningsDTO getEarnings();

    /**
     * 推客提现
     * @return
     */
    boolean earningsCash();

    /**
     * 获取推客审核列表
     * @return
     */
    List<TuikeCheckListDTO> getCheckList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize);

    /**
     * 是否审核通过操作
     * @param memberId
     * @param state
     * @return
     */
    Integer checkOperation(Integer memberId, String state);

    /**
     * 获得推客管理列表
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    List<TuikePageListDTO> getTuikeList(String searchKey, String orderColumn, String orderType,Integer page, Integer pageSize);

    /**
     * 禁用推客
     * @param tuikeId
     * @param state
     * @return
     */
    Integer forbiddenTuike(Integer tuikeId, String state);
}
