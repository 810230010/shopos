package com.wuliangit.shopos.controller.admin;

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
 * 商品分类相关
 * Created by nilme on 2017/4/10.
 */


@Controller
@RequestMapping("/admin/goodsCategory")
public class AdminGoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 商品分类列表页面
     * @return
     */
    @RequestMapping("/listPage")
    public String listPage() {
        return "admin/goodsCategory/list";
    }

    /**
     * 商品分类添加页面
     * @param model
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage(Integer parentId,Model model) {
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.BASE_URL);
        if (parentId != null){
            GoodsCategory goodsCategory = goodsCategoryService.getById(parentId);
            model.addAttribute("goodsCategory",goodsCategory);
        }
        model.addAttribute("parentId", parentId);
        return "admin/goodsCategory/add";
    }

    /**
     * 商品分类编辑页面
     * @param model
     * @param goodsCategoryId
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(Model model,Integer goodsCategoryId) {
        GoodsCategory goodsCategory = goodsCategoryService.getById(goodsCategoryId);
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("goodsCategory",goodsCategory);
        model.addAttribute("domain",QiNiuUtils.BASE_URL);
        return "admin/goodsCategory/edit";
    }

    /**
     * 获取所有分类
     * @return
     */
    @RequestMapping("/get/all")
    @ResponseBody
    public Object getAll() {
        RestResult result = new RestResult();
        List<GoodsCategory> goodsCategories = goodsCategoryService.getAllGoodsCategoryList();
        result.add("goodsCategories", goodsCategories);
        return result;
    }

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

    /**
     * 添加商品分类
     * @param goodsCategory
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(GoodsCategory goodsCategory) {
        RestResult result = new RestResult();
        int res = goodsCategoryService.createGoodsCategory(goodsCategory);
        return result;
    }

    /**
     * 编辑商品分类
     * @param goodsCategory
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(GoodsCategory goodsCategory) {
        RestResult result = new RestResult();
        int res = goodsCategoryService.updateGoodsCategory(goodsCategory);
        return result;
    }

    /**
     * 删除商品分类
     * @param goodsCategoryId
     * @return
     */
    @RequestMapping("delete")
    public Object delete(Integer goodsCategoryId){
        RestResult result = new RestResult();
        int res = goodsCategoryService.deleteCategory(goodsCategoryId);
        return result;
    }

    /**
     * 搜索商品分类
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @param parentId
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public Object AdminSearch(@RequestParam("draw") int draw,
                         @RequestParam(value = "searchKey", required = false) String searchKey,
                         @RequestParam(value = "orderColumn", required = false) String orderColumn,
                         @RequestParam(value = "orderType", required = false) String orderType,
                         @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                         @RequestParam(value = "parentId", required = false, defaultValue = "0") Integer parentId) {
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        ArrayList<GoodsCategory> goodsCategories = goodsCategoryService.AdminSearch(page, pageSize, searchKey, orderColumn, orderType,parentId);
        return new PageResult<GoodsCategory>(goodsCategories, draw);
    }
}
