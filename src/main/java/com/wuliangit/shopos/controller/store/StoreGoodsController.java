package com.wuliangit.shopos.controller.store;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.GoodsIncludeActivityDTO;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.GoodsCategory;
import com.wuliangit.shopos.entity.GoodsSku;
import com.wuliangit.shopos.service.GoodsCategoryService;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.GoodsSkuService;
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
@RequestMapping("/store/goods")
public class StoreGoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Autowired
    private GoodsSkuService goodsSkuService;

    /**
     * 商品列表页面
     * @return
     */
    @RequestMapping("/listPage")
    public String listPage(){
        return "store/goods/list";
    }

    /**
     * 商品添加页面
     * @param model
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage(Model model){
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.getBaseUrl());
        return "store/goods/add";
    }

    /**
     * 商品编辑界面
     * @param model
     * @param goodsId
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(Model model,Integer goodsId){
        GoodsIncludeActivityDTO goods = goodsService.getGoodsById(goodsId);
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.getBaseUrl());
        model.addAttribute("goods",goods);

        GoodsCategory category3 = goodsCategoryService.getById(goods.getGoodsCategory3Id());
        GoodsCategory category2 = goodsCategoryService.getById(goods.getGoodsCategory2Id());
        GoodsCategory category1 = goodsCategoryService.getById(goods.getGoodsCategory1Id());

        model.addAttribute("category1",category1.getGoodsCategoryId());
        model.addAttribute("category2",category2.getGoodsCategoryId());
        model.addAttribute("category3",category3.getGoodsCategoryId());
        return "store/goods/edit";
    }

    /**
     * 商品库存sku编辑页面
     * @param model
     * @param goodsId
     * @return
     */
    @RequestMapping("/editSkuPage")
    public String editSkuPage(Model model,Integer goodsId){
        GoodsIncludeActivityDTO goods = goodsService.getGoodsById(goodsId);
        model.addAttribute("goods",goods);

        return "store/goods/sku-edit";
    }


    /**
     * 商品sku获取接口
     * @param draw
     * @param goodsId
     * @return
     */
    @RequestMapping("/goodsSku")
    @ResponseBody
    public Object goodsSku(int draw,@RequestParam(required = true) Integer goodsId){
        List<GoodsSku> goodsSkus = goodsSkuService.getGoodsSkuByGoodsId(goodsId);
        return new PageResult<GoodsSku>(goodsSkus, draw,false);
    }

    /**
     * 删除商品图片，默认什么都没有做
     * @return
     */
    @RequestMapping("/deleteImg")
    @ResponseBody
    public Object deleteImg(){
        RestResult result = new RestResult();
        return result;
    }


    /**
     * 商品添加
     * @param goods
     * @param skuStr
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(Goods goods,String skuStr){
        RestResult result = new RestResult();
        int res = goodsService.createGoods(goods,skuStr);
        return result;
    }

    /**
     * 编辑商品详情
     * @param goods
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(Goods goods){
        RestResult result = new RestResult();
        int res = goodsService.uodateGoods(goods);
        return result;
    }

    /**
     * 商品列表查询
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
                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        ArrayList<Goods> goodses = goodsService.search(page, pageSize, searchKey, orderColumn, orderType);
        return new PageResult<Goods>(goodses, draw);
    }


    /**
     * 删除商品
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(Integer goodsId){
        RestResult result = new RestResult();
        int res = goodsService.deleteGoods(goodsId);
        return result;
    }


    /**
     * 编辑商品sku
     * @return
     */
    @RequestMapping("/updateSku")
    @ResponseBody
    public Object updateSku(String skuStr){
        RestResult result = new RestResult();
        Gson gson = new Gson();
        List<GoodsSku> skus = gson.fromJson(skuStr, new TypeToken<List<GoodsSku>>() {
        }.getType());
        int res = goodsSkuService.updateSku(skus);
        return result;
    }


    /**
     * 获取商品的简要信息
     * @param goodsId
     * @return
     */
    @RequestMapping("/getSimplGoodsInfo")
    @ResponseBody
    public Object getSimplGoodsInfo(Integer goodsId){
        RestResult result = new RestResult();
        StoreGoodsDetailDTO info = goodsService.getSimplGoodsInfo(goodsId);
        result.add("data",info);
        return result;
    }

    /**
     *
     * @param goodsId
     * @param type  0:上架 1:下架
     * @return
     */
    @RequestMapping("/updateOnshelfStatus")
    @ResponseBody
    public Object updateGoodsOnshelfStatus(Integer goodsId, Integer type){
        RestResult result = null;
        if(goodsService.updateGoodsOnshelfStatus(goodsId, type) != 1){
            result = new RestResult("未知错误", 405);
            return result;
        }
        result = new RestResult();
        return result;
    }


}
