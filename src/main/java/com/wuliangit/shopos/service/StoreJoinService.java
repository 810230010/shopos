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
     ArrayList<StoreJoinin> getJoinStores(Integer page, Integer pageSize, String searchKey, String orderColumn);
}
