package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ActivityCheckGoodsDTO;
import com.wuliangit.shopos.dto.GoodsDetailDTO;
import com.wuliangit.shopos.dto.api.ApiGoodsDTO;
import com.wuliangit.shopos.dto.api.ApiGoodsListDTO;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.model.GoodsWithoutBody;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods, Integer> {



    /**
     * 后台商品搜索
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<Goods> StoreSearch(@Param("storeId")Integer storeId,
                                 @Param("searchKey")String searchKey,
                            @Param("orderColumn")String orderColumn,
                            @Param("orderType")String orderType);

    /**
     * 不包行商品详情的商品对象
     * @param goodsId
     * @return
     */
    GoodsWithoutBody selectGoodsWithoutBodyByPrimaryKey(Integer goodsId);

    /**
     * 获取商品的简要信息
     * @param goodsId
     * @return
     */
    StoreGoodsDetailDTO getSimplGoodsInfo(Integer goodsId);

    /**
     * 通过店铺id获取店铺商品数量
     * @param storeId
     * @return
     */
    Integer getGoodsCountByStoreId(Integer storeId);

    /**
     * 接口获取商品详情
     * @param goodsId
     * @return
     */
    ApiGoodsDTO apiGetGoodsDTOById(Integer goodsId);

    /**
     * 获取移动端可以编辑的商品
     * @param storeId
     * @return
     */
    ArrayList<ApiGoodsListDTO> sellerGetGoodsCanEdit(Integer storeId);

    /**
     * 管理员查询所有商品
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<Goods> adminGetGoodsSearch(@Param("searchKey")String searchKey,
                                         @Param("orderColumn")String orderColumn,
                                         @Param("orderType")String orderType);

    /**
     * 改变商品申请状态
     * @param goodsId
     * @param reason
     * @param type   0:拒绝   1:通过  2:推荐到首页 3：下架
     * @return
     */
    int updateGoodsApplyStatus(@Param("goodsId") Integer goodsId, @Param("reason") String reason, @Param("type") Integer type);

    /**
     * 管理员得到商品详细信息
     * @return
     */
    GoodsDetailDTO adminGetGoodsDetail(@Param("goodsId") Integer goodsId);

    /**
     * 商家修改商品上下架状态
     * @param goodsId
     * @param type 0:上架 1:下架
     * @return
     */
    int updateGoodsOnshelfStatus(@Param("goodsId") Integer goodsId, @Param("type") Integer type);

    /**
     * 获取活动审核商品列表
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    List<ActivityCheckGoodsDTO> getActivityCheckGoodsList(@Param("orderColumn") String orderColumn,
                                                          @Param("orderType") String orderType,
                                                          @Param("searchKey") String searchKey);

    /**
     * 活动商品审核结果
     * @param goodsId
     * @param activityJoinState
     * @return
     */
    Integer activityGoodsCheck(@Param("goodsId") Integer goodsId,
                               @Param("activityJoinState") String activityJoinState);
}