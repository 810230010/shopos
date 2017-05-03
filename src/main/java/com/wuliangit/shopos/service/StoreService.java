package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.model.StoreBrand;
import com.wuliangit.shopos.model.StoreUser;

import java.util.List;
import java.util.Set;

/**
 * Created by nilme on 2017/3/27.
 */
public interface StoreService {


    /**
     * 创建新店铺申请
     * @param storeJoinin
     * @return
     */
    int createStoreJoinin(StoreJoinin storeJoinin);

    /**
     * 通过用户名获取店铺简要信息
     * @param memberId
     * @return
     */
    StoreUser getStoreUser(Integer memberId);

    /**
     * 店铺角色
     * @param username
     * @return
     */
    Set<String> getRoles(String username);

    /**
     * 店铺权限
     * @param username
     * @return
     */
    Set<String> getPermissions(String username);

    /**
     * 通过店铺id获取店铺信息
     * @param storeId
     * @return
     */
    Store getStoreByStoreId(Integer storeId);

    /**
     * 更新店铺信息店铺,并更新店铺缓存信息
     * @param store
     * @return
     */
    int updateStore(Store store);

    /**
     * 获取店铺的品牌信息
     * @param page
     * @param pageSize
     * @param searchKey
     * @param storeId
     * @return
     */
    List<StoreBrand> getStoreBrands(Integer page, Integer pageSize, String searchKey, Integer storeId);
    /**
     * 更改店铺某品牌上下架状态
     * @param id
     * @param status
     * @return
     */
    int updateBrandStatus(Integer id, String status);
}
