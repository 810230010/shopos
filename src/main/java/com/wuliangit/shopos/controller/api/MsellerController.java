package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by nilme on 2017/5/27.
 */

@RestController
@RequestMapping(value = "/api/v1/seller")
public class MsellerController {

    @Autowired
    private GoodsService goodsService;

    /**
     *
     * @param goodsCategory1Id 一级分类
     * @param goodsCategory2Id 二级分类
     * @param goodsCategory3Id 三级分类
     * @param name 商品名称
     * @param price 价格
     * @param carriage 邮费
     * @param storage 库存
     * @param type 类型 商品类型 GOODS_TYPE_ACTIVITY(活动商品); GOODS_TYPE_NORMAL(普通商品);SECOND_HAND(二手)
     * @param unit 单位
     * @param goodsBody 商品描述
     * @return
     */
    @RequestMapping(value = "/goods/add" ,method = RequestMethod.POST)
    public Object GoodsAdd(Integer goodsCategory1Id,
                           Integer goodsCategory2Id,
                           Integer goodsCategory3Id,
                           String name,
                           BigDecimal price,
                           BigDecimal carriage,
                           Integer storage,
                           String type,
                           String unit,
                           String goodsBody,
                           String images){
        RestResult result = new RestResult();
        int res = goodsService.apiCreateGooods(goodsCategory1Id,goodsCategory2Id,goodsCategory3Id,
                name,price,carriage,storage,type,unit,goodsBody,images);
        return result;
    }

}
