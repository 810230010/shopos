package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.*;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.model.StoreMin;

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
     * 获取商家列表的数据
     * @param page
     * @param pageSize
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    List<StorePageListDTO> getStoreList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey);

    /**
     * 更改店铺状态
     * @param storeId
     * @param state
     * @return
     */
    Integer updateStoreState(Integer storeId, String state);

    /**
     * @Description: 获取商家详情
     * @Author: pangweichao
     * @Date: 16:15 2017/5/16
     * @Param: [storeId]
     * @return: StoreDetailDTO
     */
    StoreDetailDTO getStoreDetailInfo(Integer storeId);

    /**
     * 通过店铺id获取店铺简要信息
     * @param storeId
     * @return
     */
    StoreMin getStoreMinByStoreId(Integer storeId);

    /**
     * 接口搜索店铺
     * @param page
     * @param pageSize
     * @param searchKey
     * @param order
     * @param type
     * @return
     */
    List<ApiStoreListDTO> apiStoreSearch(Integer page, Integer pageSize, String searchKey, String order, String type);

    /**
     * 获取店铺详情
     * @param storeId
     * @return
     */
    ApiStoreDTO apiGetStoreDTO(Integer storeId);

    /**
     * 创建店铺
     * @param store
     */
    int createStore(Store store);

    /**
     * 通过绑定的会员用户名获取店铺
     * @param phone
     * @return
     */
    Store getStoreByBindMemberUsername(String phone);

    /**
     * @Description: 获取所有商铺
     * @Author: pangweichao
     * @Date: 12:25 2017/6/3
     * @Param: []
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreMailToSelectDTO>
     */
    List<AdminMailToSelectDTO> getAllStore();
}
