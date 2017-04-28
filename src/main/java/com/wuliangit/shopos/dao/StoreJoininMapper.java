package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.StoreJoinin;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface StoreJoininMapper extends BaseMapper<StoreJoinin, Integer> {
     ArrayList<StoreJoinin> queryJoinStores(String searchKey, String orderColumn);
}