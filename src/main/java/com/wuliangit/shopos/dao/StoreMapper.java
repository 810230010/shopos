package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreBrand;
import com.wuliangit.shopos.model.StoreUser;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface StoreMapper extends BaseMapper<Store, Integer> {
    /**
     * 通过用户名获取店铺简要信息
     * @param memberId
     * @return
     */
    StoreUser getStoreUser(Integer memberId);


}