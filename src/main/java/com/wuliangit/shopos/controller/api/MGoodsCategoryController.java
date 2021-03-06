package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.api.ApiGoodsCategoryDOT;
import com.wuliangit.shopos.dto.api.ApiGoodsCategoryWithChildDTO;
import com.wuliangit.shopos.entity.GoodsCategory;
import com.wuliangit.shopos.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nilme on 2017/5/14.
 */

@RestController
@RequestMapping("/api/v1/public/goodsCategory")
public class MGoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 移动端接口获取分类
     * @return
     */
    @RequestMapping("/grade")
    public Object getGoodsCategory(@RequestParam(value = "parentId", required = false, defaultValue = "0") Integer parentId){
        RestResult result = new RestResult();
        List<GoodsCategory> goodsCategories = goodsCategoryService.getGoodsCategoryListByParentId(parentId);
        result.add("goodsCategories",goodsCategories);
        return result;
    }


    /**
     * 移动端接口获取一级分类
     * @return
     */
    @RequestMapping("/getLevelOne")
    public Object getGoodsCategoryLevelOne(){
        RestResult result = new RestResult();
        List<ApiGoodsCategoryDOT> goodsCategories = goodsCategoryService.getGoodsCategoryLevelOne();
        result.add("goodsCategories",goodsCategories);
        return result;
    }


    /**
     * 移动端接口获取二级、三级分类
     * @return
     */
    @RequestMapping("/getLevelSecond")
    public Object getGoodsCategoryLevelSecond(Integer parentId){
        RestResult result = new RestResult();
        List<ApiGoodsCategoryWithChildDTO> goodsCategories = goodsCategoryService.getGoodsCategoryLevelSecond(parentId);
        result.add("goodsCategories",goodsCategories);
        return result;
    }

}
