package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.GoodsSku;

import java.util.List;

/**
 * Created by nilme on 2017/4/27.
 */
public interface GoodsSkuService {


    List<GoodsSku> getGoodsSkuByGoodsId(Integer goodsId);

    /**
     * 更新商品sku
     * @param skus
     * @return
     */
    int updateSku(List<GoodsSku> skus);
}
