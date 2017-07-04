package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.*;
import com.wuliangit.shopos.dto.api.ApiSellerInfo;
import com.wuliangit.shopos.dto.api.ApiStoreDTO;
import com.wuliangit.shopos.dto.api.ApiStoreListDTO;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreMin;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
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

    /**
     * @Description: 获取所有商铺
     * @Author: pangweichao
     * @Date: 12:25 2017/6/3
     * @Param: []
     * @return: java.util.List<com.wuliangit.shopos.dto.StoreMailToSelectDTO>
     */
    List<AdminMailToSelectDTO> getAllStore();

    /**
     * 通过用户id获取用户绑定的店铺信息
     * @param username
     * @return
     */
    ApiSellerInfo getSellerInfoBybindMemberUsername(String username);

    /**
     * 更新商户交易总额
     * @param storeId
     * @param tradingVolume
     */
    void updateTradingVolume(@Param("storeId") Integer storeId,@Param("tradingVolume") BigDecimal tradingVolume);

    /**
     * 获取商户的总交易额
     * @param storeId
     * @return
     */
    BigDecimal getTradingVolume(Integer storeId);

    /**
     * 更新商户等级
     * @param storeId
     * @param gradeId
     */
    void updateStoreGradeId(@Param("storeId") Integer storeId,@Param("gradeId") int gradeId);

    /**
     * 更新商户订单数
     * @param storeId
     */
    void updateStoreOrderAmount(@Param("storeId") Integer storeId,@Param("orderAmount")Integer orderAmount);

    /**
     * 获取商户订单总数
     * @param storeId
     * @return
     */
    Integer getStoreOrderAmount(Integer storeId);

    /**
     * 获取商户的现有评分（商品描述相符度）
     * @param storeId
     */
    BigDecimal getDesccredit(Integer storeId);

    /**
     * 更新商户评分（商品描述相符度）
     * @param storeId
     * @param desccredit
     */
    void updateStoreDesccredit(@Param("storeId") Integer storeId,@Param("desccredit")BigDecimal desccredit);
}