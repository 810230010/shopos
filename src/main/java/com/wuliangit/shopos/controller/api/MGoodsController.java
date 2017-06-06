package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsListDTO;
import com.wuliangit.shopos.dto.ApiGoodsDTO;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.GoodsSku;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.service.CollectService;
import com.wuliangit.shopos.service.EvaluateGoodsService;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.GoodsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品相关接口
 * Created by nilme on 2017/3/30.
 */

@RestController
@RequestMapping("/api/v1/public/goods")
public class MGoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsSearchService goodsSearchService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private EvaluateGoodsService evaluateGoodsService;


    /**
     * 商品搜索
     *
     * @param page            页码
     * @param pageSize        页大小
     * @param searchKey       搜索值
     * @param orderType       排序类型 默认综合 salenum:销量, collect:搜藏数量, evaluationGoodStar:评价, click:点击量, evaluationCount:评价数
     * @param brandId         品牌类型id
     * @param goodsCategoryId 商品分类id
     * @param storeId         店铺id
     * @param type            商品类型 GOODS_TYPE_ACTIVITY(活动商品); GOODS_TYPE_NORMAL(普通商品);SECOND_HAND(二手)
     * @return
     */
    @RequestMapping("/search")
    public Object goodsSearch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(value = "searchKey", required = false) String searchKey,
                              @RequestParam(value = "orderType", required = false, defaultValue = "salenum") String orderType,
                              @RequestParam(value = "brandId", required = false) Integer brandId,
                              @RequestParam(value = "goodsCategoryId", required = false) Integer goodsCategoryId,
                              @RequestParam(value = "storeId", required = false) Integer storeId,
                              @RequestParam(value = "type", required = false) String type,
                              @RequestParam(value = "storeGoodsCategoryId", required = false) Integer storeGoodsCategoryId) {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods = goodsSearchService.apiGoodsSearch(page, pageSize, searchKey, orderType, brandId, goodsCategoryId, storeId, storeGoodsCategoryId, type);
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
        ApiGoodsDTO goods = goodsService.apiGetGoodsDTOById(goodsId);
        List<GoodsSku> goodsSku = goodsService.getGoodsSkuByGoodsId(goodsId);

        //转化为字典型，方便前段处理
        Map<String, GoodsSku> goodsSkuMap = new HashMap<String, GoodsSku>();
        for (GoodsSku sku : goodsSku) {
            goodsSkuMap.put(sku.getSkuValue(), sku);
        }

        boolean isCollect = collectService.isCollectGoods(goodsId);

        List<ApiEvaluateGoodsListDTO> evaluateList = evaluateGoodsService.getEvaluateGoodsList(1, 2, goodsId);

        result.add("isCollect", isCollect);
        result.add("goods", goods);
        result.add("goodsSku", goodsSkuMap);
        result.add("evaluates",evaluateList);
        return result;
    }

    /**
     * 企业直销商品专区
     *
     * @param page            页码
     * @param pageSize        页大小
     * @param searchKey       搜索值
     * @param orderType       排序类型 默认综合 salenum:销量, collect:搜藏数量, evaluationGoodStar:评价, click:点击量, evaluationCount:评价数
     * @return
     */
    @RequestMapping("/directSellingSearch")
    public Object directSellingSearch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(value = "searchKey", required = false) String searchKey,
                              @RequestParam(value = "orderType", required = false, defaultValue = "salenum") String orderType) {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods = goodsSearchService.directSellingSearch(page, pageSize, searchKey, orderType);
        result.add("goods", goods);
        return result;
    }

    /**
     * 企业新品商品专区
     *
     * @param page            页码
     * @param pageSize        页大小
     * @param searchKey       搜索值
     * @param orderType       排序类型 默认综合 salenum:销量, collect:搜藏数量, evaluationGoodStar:评价, click:点击量, evaluationCount:评价数
     * @return
     */
    @RequestMapping("/newGoodsSearch")
    public Object newGoodsSearch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                      @RequestParam(value = "searchKey", required = false) String searchKey,
                                      @RequestParam(value = "orderType", required = false, defaultValue = "salenum") String orderType) {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods = goodsSearchService.newGoodsSearch(page, pageSize, searchKey, orderType);
        result.add("goods", goods);
        return result;
    }

    /**
     * 企业活动商品专区
     *
     * @param page            页码
     * @param pageSize        页大小
     * @param searchKey       搜索值
     * @param orderType       排序类型 默认综合 salenum:销量, collect:搜藏数量, evaluationGoodStar:评价, click:点击量, evaluationCount:评价数
     * @return
     */
    @RequestMapping("/activityGoodsSearch")
    public Object activityGoodsSearch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                      @RequestParam(value = "searchKey", required = false) String searchKey,
                                      @RequestParam(value = "orderType", required = false, defaultValue = "salenum") String orderType) {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods = goodsSearchService.activityGoodsSearch(page, pageSize, searchKey, orderType);
        result.add("goods", goods);
        return result;
    }

    /**
     * 一口秒价专区
     *
     * @param page            页码
     * @param pageSize        页大小
     * @param searchKey       搜索值
     * @param orderType       排序类型 默认综合 salenum:销量, collect:搜藏数量, evaluationGoodStar:评价, click:点击量, evaluationCount:评价数
     * @return
     */
    @RequestMapping("/seckillGoodsSearch")
    public Object seckillGoodsSearch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "searchKey", required = false) String searchKey,
                                     @RequestParam(value = "orderType", required = false, defaultValue = "salenum") String orderType) {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods = goodsSearchService.seckillGoodsSearch(page, pageSize, searchKey, orderType);
        result.add("goods", goods);
        return result;
    }

    /**
     * 普通商品专区
     *
     * @param page            页码
     * @param pageSize        页大小
     * @param searchKey       搜索值
     * @param orderType       排序类型 默认综合 salenum:销量, collect:搜藏数量, evaluationGoodStar:评价, click:点击量, evaluationCount:评价数
     * @return
     */
    @RequestMapping("/normalGoodsSearch")
    public Object normalGoodsSearch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "searchKey", required = false) String searchKey,
                                     @RequestParam(value = "orderType", required = false, defaultValue = "salenum") String orderType) {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods = goodsSearchService.normalGoodsSearch(page, pageSize, searchKey, orderType);
        result.add("goods", goods);
        return result;
    }

    /**
     * 首页商品
     * @return
     */
    @RequestMapping("/indexGoods")
    public Object indexGoods() {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods = goodsSearchService.indexGoods();
        result.add("goods", goods);
        return result;
    }

}
