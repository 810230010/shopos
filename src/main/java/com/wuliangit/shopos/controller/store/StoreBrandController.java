package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.entity.GoodsCategory;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreBrand;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.BrandService;
import com.wuliangit.shopos.service.GoodsCategoryService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JangJanPing on 2017/5/1.
 * @description 店铺用户的品牌操作controller
 */
@Controller
@RequestMapping("/store/brand")
public class StoreBrandController {
     @Autowired
     private StoreService storeService;
     @Autowired
     private BrandService brandService;
     @Autowired
     private GoodsCategoryService goodsCategoryService;
    /**
     * 跳转到店铺品牌页面
     * @return
     */
    @RequestMapping("/listPage")
    public String jumpToBrandListPage() {
        return "/store/brand/list";
    }

    /**
     * 查询店铺品牌列表
     * @param draw
     * @param searchKey
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public Object searchBrands(@RequestParam("draw") int draw,
                               @RequestParam(value = "searchKey", required = false) String searchKey,
                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        StoreUser store = WebUtil.getCurrentStore();
        Integer storeId = store.getStoreId();
        List<StoreBrand> storeBrands = storeService.getStoreBrands(page, pageSize, searchKey, storeId);
        return new PageResult<StoreBrand>(storeBrands, draw);
    }
    /**
     * 更改店铺某品牌上下架状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateBrandStatus")
    @ResponseBody
    public String changOnshelfStatus(Integer id, String status){
        storeService.updateBrandStatus(id, status);
        return "ok";
    }

    /**
     * 删除某个店铺的品牌
     * @param id
     * @return
     */
    @RequestMapping("/deleteBrand")
    @ResponseBody
    public String deleteStoreBrand(Integer id) {
        storeService.deleteStoreBrand(id);
        return "ok";
    }

    /**
     * 跳转到申请入驻页面
     * @return
     */
    @RequestMapping("/joinPage")
    public String jumpToDetailPage() {
        return "/store/brand/joinBrand";
    }

    /**
     * 获取所有品牌
     * @return
     */
    @RequestMapping("/allBrands")
    @ResponseBody
   public Object getAllBrands(){
        RestResult result = new RestResult();
        List<Brand> brands = storeService.getAllBrands();
        result.add("brands", brands);
        return result;
   }

    /**
     * 店铺申请入驻品牌
     * @return
     */
    @RequestMapping("/applyForJoinBrand")
    @ResponseBody
    public Object applyForJoinBrand(Integer brandId){
       RestResult result = new RestResult();
       StoreUser store = WebUtil.getCurrentStore();
       Integer storeId = store.getStoreId();
       storeService.addStoreBrand(storeId, brandId);
       return result;
   }

    /**
     * 跳转到店铺添加品牌页面
     * @return
     */
    @RequestMapping("/addPage")
   public String jumpToAddBrandPage(Model model) {
       model.addAttribute("uploadToken", QiNiuUtils.getToken());
       return "/store/brand/add";
   }

    /**
     * 验证品牌名是否存在
     * @param brandName
     * @return
     */
    @RequestMapping("/checkBrandName")
    @ResponseBody
    public String checkBrandNameExistence(String brandName) {
        String message = "";
        if (brandService.hasBrandName(brandName)) {
            message = "品牌名已存在";
        } else {
            message = "可以添加该品牌名";
        }
        return message;
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
     * 店铺添加品牌
     * @param brand
     * @return
     */
    @RequestMapping("/addBrand")
    @ResponseBody
    public Object addBrand(Brand brand){
        RestResult result = new RestResult();
        StoreUser store = WebUtil.getCurrentStore();
        Integer storeId = store.getStoreId();
        brand.setStoreId(storeId);
        brand.setPic(QiNiuUtils.getRealUrl(brand.getPic()));
        brandService.addBrand(brand);
        return result;
    }
}
