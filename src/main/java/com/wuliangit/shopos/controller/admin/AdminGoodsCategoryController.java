package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.entity.GoodsCategory;
import com.wuliangit.shopos.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/4/10.
 */


@Controller
@RequestMapping("/admin/goodsCategory")
public class AdminGoodsCategoryController {


    @Autowired
    private GoodsCategoryService goodsCategoryService;


    @RequestMapping("/listPage")
    public String listPage() {
        return "admin/goodsCategory/list";
    }

    @RequestMapping("/addPage")
    public String addPage(Model model) {
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        return "admin/goodsCategory/add";
    }

    @RequestMapping("/editPage")
    public String editPage(Model model,Integer goodsCategoryId) {
        GoodsCategory goodsCategory = goodsCategoryService.getById(goodsCategoryId);
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("goodsCategory",goodsCategory);
        return "admin/goodsCategory/edit";
    }

    @RequestMapping("/get/all")
    @ResponseBody
    public Object getAll() {
        RestResult result = new RestResult();
        List<GoodsCategory> goodsCategories = goodsCategoryService.getAllGoodsCategoryList();
        result.add("goodsCategories", goodsCategories);
        return result;
    }

    @RequestMapping("/get/grade")
    @ResponseBody
    public Object getGrade(@RequestParam(value = "parentId", required = false, defaultValue = "0") Integer parentId) {
        RestResult result = new RestResult();
        List<GoodsCategory> goodsCategories = goodsCategoryService.getGoodsCategoryListByParentId(parentId);
        result.add("goodsCategories", goodsCategories);
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object add(GoodsCategory goodsCategory) {
        RestResult result = new RestResult();
        goodsCategory.setImg(CoreConstants.IMG_BASE_URL + goodsCategory.getImg());
        int res = goodsCategoryService.createGoodsCategory(goodsCategory);
        return result;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(GoodsCategory goodsCategory) {
        RestResult result = new RestResult();
        goodsCategory.setImg(QiNiuUtils.getRealUrl(goodsCategory.getImg()));
        int res = goodsCategoryService.updateGoodsCategory(goodsCategory);
        return result;
    }

    @RequestMapping("delete")
    public Object delete(Integer goodsCategoryId){
        RestResult result = new RestResult();
        int res = goodsCategoryService.deleteCategory(goodsCategoryId);
        return result;
    }


    @RequestMapping("/search")
    @ResponseBody
    public Object search(@RequestParam("draw") int draw,
                         @RequestParam(value = "searchKey", required = false) String searchKey,
                         @RequestParam(value = "orderColumn", required = false) String orderColumn,
                         @RequestParam(value = "orderType", required = false) String orderType,
                         @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                         @RequestParam(value = "parentId", required = false, defaultValue = "0") Integer parentId) {
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        ArrayList<GoodsCategory> goodsCategories = goodsCategoryService.search(page, pageSize, searchKey, orderColumn, orderType,parentId);
        return new PageResult<GoodsCategory>(goodsCategories, draw);
    }
}
