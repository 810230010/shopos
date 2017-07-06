package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.TuikeCheckListDTO;
import com.wuliangit.shopos.dto.TuikePageListDTO;
import com.wuliangit.shopos.entity.Tuike;
import com.wuliangit.shopos.dto.api.ApiTuikeShareDTO;

import java.util.List;

/**
 * Created by nilme on 2017/3/27.
 */
public interface TuikeService {

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

    /**
     * 通过用户id获取推客信息
     * @param userId
     * @return
     */
    Tuike getTuikeByMemberId(Integer userId);

    /**
     * 获得推客信息
     * @param memberId
     * @return
     */
    Tuike getTuikeInfo(Integer memberId);

    /**
     * 推客推广商品的链接
     * @return
     */
    String getTuikeCode(Integer memberId);

    /**
     * 获取成功分享的数据
     * @param page
     * @param pageSize
     * @param searchKey
     * @param order
     * @return
     */
    List<ApiTuikeShareDTO> getShareInfo(Integer page, Integer pageSize, String searchKey, String order,Integer tuikeId);
}
