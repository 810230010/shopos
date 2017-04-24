package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiGoodsListDTO;
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
}
