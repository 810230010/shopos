package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiEarningsDTO;
import com.wuliangit.shopos.dto.TuikeMemberDTO;

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
    List<TuikeMemberDTO> getCheckList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize);

    /**
     * 是否审核通过操作
     * @param memberId
     * @param state
     * @return
     */
    Integer checkOperation(Integer memberId, String state);
}
