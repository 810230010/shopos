package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreBrand;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.StoreService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        StoreUser store = (StoreUser) SecurityUtils.getSubject()
                .getSession()
                .getAttribute(CoreConstants.SESSION_CURRENT_STORE);
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
       StoreUser store = (StoreUser) SecurityUtils.getSubject()
               .getSession()
               .getAttribute(CoreConstants.SESSION_CURRENT_STORE);
       Integer storeId = store.getStoreId();
       storeService.addStoreBrand(storeId, brandId);
       return result;
   }
}
