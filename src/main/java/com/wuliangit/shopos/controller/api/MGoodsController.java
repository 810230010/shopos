package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/30.
 */

@RestController
@RequestMapping("/api/v1/public")
public class MGoodsController {


    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SearchService searchService;

    /**
     *
     * @param page    页码
     * @param pageSize 页大小
     * @param searchKey 搜索值
     * @param order   排序类型
     * @param brandId   品牌类型id
     * @param goodsCategoryId   商品分类id
     * @return
     */
    @RequestMapping("/goods/search")
    public Object goodsSearch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(value = "searchKey", required = false) String searchKey,
                              @RequestParam(value = "orderType", required = false) String order,
                              @RequestParam(value = "brandId", required = false) Integer brandId,
                              @RequestParam(value = "goodsCategoryId", required = false) Integer goodsCategoryId) {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods = searchService.apiGoodsSearch(page, pageSize, searchKey, order, brandId, goodsCategoryId);
        result.add("goods", goods);
        return result;
    }
}
