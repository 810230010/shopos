package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.StoreJoinin;

import java.util.ArrayList;

/**
 * Created by JangJanPing on 2017/4/27.
 * 管理员操作店铺service
 */
public interface StoreJoinService {

    /**
     * 获得查询列表
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
     ArrayList<StoreJoinin> getJoinStores(Integer page, Integer pageSize, String searchKey);

    /**
     * 更改审批不通过的店铺状态
     * @param joininMessage
     * @param memberId
     * @return
     */
     int updateRejectedJoininStoreStatus(String joininMessage, Integer memberId);

    /**
     * 用户申请成为商家请求通过
     * @param memberId
     * @return
     */
    int passApplyForJoininStore(Integer memberId);
}
