package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.GoodsSku;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/3/30.
 */
public interface GoodsService {
    /**
     * 首页获取商品（搜索）
     * @param page
     * @param pageSize
     * @param searchKey
     * @param order
     * @return
     */
    ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page, Integer pageSize, String searchKey, String order);

    /**
     * 创建商品
     * @param goods
     * @param skuStr
     * @return
     */
    int createGoods(Goods goods, String skuStr);


    /**
     * 获取商品详情
     * @param goodsId
     * @return
     */
    Goods getGoodsById(Integer goodsId);

    /**
     * 获取商品sku信息
     * @param goodsId
     * @return
     */
    List<GoodsSku> getGoodsSkuByGoodsId(Integer goodsId);



    /**
     * 后台商品搜索
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param parentId
     * @return
     */
    ArrayList<Goods> search(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType, Integer parentId);

    /**
     * 更新商品详情
     * @param goods
     * @return
     */
    int uodateGoods(Goods goods);

    /**
     * 删除商品
     * @param goodsId
     * @return
     */
    int deleteGoods(Integer goodsId);

    /**
     * 获取商铺商品
     * @param storeId
     * @return
     */
    List<StoreGoodsDetailDTO> getStoreGoods(Integer storeId);

    /**
     * 获取商品的简要信息
     * @param goodsId
     * @return
     */
    StoreGoodsDetailDTO getSimplGoodsInfo(Integer goodsId);
}
