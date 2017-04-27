package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.GoodsCategory;
import com.wuliangit.shopos.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nilme on 2017/4/24.
 */

@Controller
@RequestMapping("/store/goodsCategory")
public class StoreGoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 获取子分类
     * @param parentId
     * @return
     */
    @RequestMapping("/get/grade")
    @ResponseBody
    public Object getGrade(@RequestParam(value = "parentId", required = false, defaultValue = "0") Integer parentId) {
        RestResult result = new RestResult();
        List<GoodsCategory> goodsCategories = goodsCategoryService.getGoodsCategoryListByParentId(parentId);
        result.add("goodsCategories", goodsCategories);
        return result;
    }

}
