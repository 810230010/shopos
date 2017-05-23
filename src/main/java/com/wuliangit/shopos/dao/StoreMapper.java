package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiStoreDTO;
import com.wuliangit.shopos.dto.ApiStoreListDTO;
import com.wuliangit.shopos.dto.StoreDetailDTO;
import com.wuliangit.shopos.dto.StorePageListDTO;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreMin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper extends BaseMapper<Store, Integer> {

    /**
     * 获取商家列表的数据
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    List<StorePageListDTO> getStoreList(@Param("orderColumn") String orderColumn,@Param("orderType") String orderType,@Param("searchKey") String searchKey);

    /**
     * 更改商家状态
     * @param storeId
     * @param state
     * @return
     */
    Integer updateStoreState(@Param("storeId") Integer storeId,@Param("state") String state);

    /**
     * 获取店铺简要信息
     * @param storeId
     * @return
     */
    StoreMin getStoreMinByStoreId(Integer storeId);

    /**
     * @Description: 获取商家详情
     * @Author: pangweichao
     * @Date: 16:15 2017/5/16
     * @Param: [storeId]
     * @return: StoreDetailDTO
     */
    StoreDetailDTO getStoreDetailInfo(Integer storeId);

    /**
     * 接口搜索店铺
     * @param searchKey
     * @param order
     * @param type
     * @return
     */
    List<ApiStoreListDTO> apiStoreSearch(@Param("searchKey")String searchKey,
                                         @Param("order")String order,
                                         @Param("type")String type);

    /**
     * api获取店铺详情
     * @param storeId
     * @return
     */
    ApiStoreDTO getApiStoreDTOById(Integer storeId);

    /**
     * 通过绑定的会员用户名获取店铺
     * @param phone
     * @return
     */
    Store getStoreByBindMemberUsername(String phone);
}