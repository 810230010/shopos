package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.StoreAccountListDTO;
import com.wuliangit.shopos.entity.StoreAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreAccountMapper extends BaseMapper<StoreAccount, Integer> {

    /**
     * 通过店铺id获取店铺账户
     * @param storeId
     * @return
     */
    StoreAccount getByStoreId(Integer storeId);

    /**
     * @Description: 获取商家账户管理页面list数据
     * @Author: pangweichao
     * @Date: 10:15 2017/6/2
     * @Param: [orderColumn, orderType, searchKey]
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreAccountListDTO>
     */
    List<StoreAccountListDTO> getStoreAccountListDate(@Param("orderColumn") String orderColumn,@Param("orderType") String orderType,@Param("searchKey") String searchKey);
}