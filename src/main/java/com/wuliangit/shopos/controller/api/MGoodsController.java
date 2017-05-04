package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.GoodsSku;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.GoodsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/3/30.
 */

@RestController
@RequestMapping("/api/v1/public/goods")
public class MGoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsSearchService goodsSearchService;


    /**
     * 商品搜索
     *
     * @param page            页码
     * @param pageSize        页大小
     * @param searchKey       搜索值
     * @param order           排序类型
     * @param brandId         品牌类型id
     * @param goodsCategoryId 商品分类id
     * @param type            商品类型 GOODS_TYPE_ACTIVITY(活动商品);GOODS_TYPE_NORMAL(普通商品)
     * @return
     */
    @RequestMapping("/search")
    public Object goodsSearch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(value = "searchKey", required = false) String searchKey,
                              @RequestParam(value = "orderType", required = false) String order,
                              @RequestParam(value = "brandId", required = false) Integer brandId,
                              @RequestParam(value = "goodsCategoryId", required = false) Integer goodsCategoryId,
                              @RequestParam(value = "storeId", required = false) Integer storeId,
                              @RequestParam(value = "type", required = false) String type,
                              @RequestParam(value = "storeGoodsCategoryId", required = false) Integer storeGoodsCategoryId) {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods = goodsSearchService.apiGoodsSearch(page, pageSize, searchKey, order, brandId, goodsCategoryId, storeId, storeGoodsCategoryId, type);
        result.add("goods", goods);
        return result;
    }

    /**
     * 商品详情接口
     *
     * @param goodsId
     * @return
     */
    @RequestMapping("/get")
    public Object getGoods(Integer goodsId) {
        RestResult result = new RestResult();
        Goods goods = goodsService.getGoodsById(goodsId);
        List<GoodsSku> goodsSku = goodsService.getGoodsSkuByGoodsId(goodsId);
        result.add("goods", goods);
        result.add("goodsSku", goodsSku);
        return result;
    }

}
