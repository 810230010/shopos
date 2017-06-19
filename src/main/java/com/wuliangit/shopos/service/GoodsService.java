package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiGoodsDTO;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.GoodsSku;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/3/30.
 */
public interface GoodsService {
    /**
     * 首页获取商品（搜索）
     *
     * @param page
     * @param pageSize
     * @param searchKey
     * @param order
     * @return
     */
    ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page, Integer pageSize, String searchKey, String order);

    /**
     * 创建商品
     *
     * @param goods
     * @param skuStr
     * @return
     */
    int createGoods(Goods goods, String skuStr);


    /**
     * 获取商品详情
     *
     * @param goodsId
     * @return
     */
    Goods getGoodsById(Integer goodsId);

    /**
     * 获取商品sku信息
     *
     * @param goodsId
     * @return
     */
    List<GoodsSku> getGoodsSkuByGoodsId(Integer goodsId);


    /**
     * 后台商品搜索
     *
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    ArrayList<Goods> search(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);

    /**
     * 更新商品详情
     *
     * @param goods
     * @return
     */
    int uodateGoods(Goods goods);

    /**
     * 删除商品
     *
     * @param goodsId
     * @return
     */
    int deleteGoods(Integer goodsId);

    /**
     * 获取商品的简要信息
     *
     * @param goodsId
     * @return
     */
    StoreGoodsDetailDTO getSimplGoodsInfo(Integer goodsId);

    /**
     * 通过店铺id获取店铺商品数量
     *
     * @param storeId
     * @return
     */
    Integer getGoodsCountByStoreId(Integer storeId);

    /**
     * 移动端创建商品
     *
     * @param goodsCategory1Id
     * @param goodsCategory2Id
     * @param goodsCategory3Id
     * @param name
     * @param price
     * @param carriage
     * @param storage
     * @param type
     * @param unit
     * @param goodsBody
     * @param images
     * @return
     */
    int apiCreateGooods(Integer goodsCategory1Id, Integer goodsCategory2Id,
                        Integer goodsCategory3Id, String name, BigDecimal price, BigDecimal carriage,
                        Integer storage, String type, String unit, String goodsBody, String images);

    /**
     * 接口获取商品详情
     * @param goodsId
     * @return
     */
    ApiGoodsDTO apiGetGoodsDTOById(Integer goodsId);

    /**
     * api更新商品
     *
     * @param goodsId
     * @param goodsCategory1Id
     * @param goodsCategory2Id
     * @param goodsCategory3Id
     * @param name
     * @param price
     * @param carriage
     * @param storage
     * @param type
     * @param unit
     * @param goodsBody
     * @param images
     * @return
     */
    int apiUpdateGoods(Integer goodsId, Integer goodsCategory1Id, Integer goodsCategory2Id, Integer goodsCategory3Id, String name, BigDecimal price, BigDecimal carriage, Integer storage, String type, String unit, String goodsBody, String images);
}
