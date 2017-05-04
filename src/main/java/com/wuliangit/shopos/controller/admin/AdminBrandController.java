package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.entity.GoodsCategory;
import com.wuliangit.shopos.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/4/14.
 */
@Controller
@RequestMapping("/admin/brand")
public class AdminBrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 品牌列表页面
     * @return
     */
    @RequestMapping(value = ("/brandListPage"))
    public String brandListPage() {
        return "admin/brand/list";
    }

    /**
     *
     * 添加品牌页面
     * @return
     */
    @RequestMapping(value = ("/addPage"))
    public String addPage(Model model) {
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        return "admin/brand/add";
    }

    /**
     * 编辑页面跳转
     * @param model
     * @param brandId
     * @return
     */
    @RequestMapping(value = ("/editPage"))
    public String addPage(Model model, Integer brandId) {
        Brand brand = brandService.getBrandById(brandId);
        model.addAttribute("brand", brand);
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        return "admin/brand/edit";
    }

    /**
     * 添加品牌
     * @param brand
     * @return
     */
    @RequestMapping(value = ("/addBrand"), method = RequestMethod.POST)
    @ResponseBody
    public Object addBrand(Brand brand) {
        RestResult result = new RestResult();
        brand.setPic(QiNiuUtils.BASE_URL + brand.getPic());
        brandService.addBrand(brand);
        return result;
    }

    /**
     * 查询品牌列表
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public Object search(@RequestParam("draw") int draw,
                         @RequestParam(value = "searchKey", required = false) String searchKey,
                         @RequestParam(value = "orderColumn", required = false) String orderColumn,
                         @RequestParam(value = "orderType", required = false) String orderType,
                         @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        ArrayList<Brand> brands = brandService.search(page, pageSize, searchKey, orderColumn, orderType);
        return new PageResult<Brand>(brands, draw);
    }

    /**
     * 修改品牌
     * @param brand
     * @return
     */
    @RequestMapping(value = "/editBrand", method = RequestMethod.POST)
    @ResponseBody
    public Object updateBrand(Brand brand) {
        RestResult result = new RestResult();
        if (brand.getPic().length() > 0) {
            brand.setPic(QiNiuUtils.getRealUrl(brand.getPic()));
        } else {
            brand.setPic(null);
        }
        brandService.updateBrand(brand);
        return result;
    }

    /**
     * 验证品牌名是否存在
     * @param brandName
     * @return
     */
    @RequestMapping(value = ("/checkBrandName"), method = RequestMethod.POST)
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
     * 删除品牌
     * @param brandId
     * @return
     */
    @RequestMapping(value = ("/deleteBrand"), method = RequestMethod.GET)
    @ResponseBody
    public Object deleteBrand(Integer brandId) {
        RestResult result = new RestResult();
        brandService.deleteBrandByID(brandId);
        return result;
    }

    /**
     * 跳转到validate_brand.vm
     * @return
     */
    @RequestMapping("/validateBrandPage")
    public String jumpToValidateBrandPage(){
        return "/admin/brand/validate_brand";
    }

    /**
     * 跳转到validate_store_brand.vm
     * @return
     */
    @RequestMapping("/validateStoreBrandPage")
    public String turnToValidateStoreBrandPage(){
        return "/admin/brand/validate_store_brand";
    }
}
