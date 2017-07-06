package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.StoreGoodsAd;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.StoreGoodsAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nilme on 2017/5/8.
 */
@Controller
@RequestMapping("/store/goodsAd")
public class StoreGoodsAdController {

    @Autowired
    private StoreGoodsAdService storeGoodsAdService;

    /**
     * 获取商品广告设置列表页面
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String showAdPage(Model model){
        return "/store/storeGoodsAd/ad_list";
    }

    /**
     * 获取修改商品广告的修改界面
     * @param model
     * @param goodsId
     * @return
     */
    @RequestMapping("/updateAdPage")
    public String updateAdPage(Model model,Integer goodsId, String name, String img){
        StoreGoodsDetailDTO result = new StoreGoodsDetailDTO(goodsId,name,img);
        model.addAttribute("goods",result);
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.getBaseUrl());
        return "/store/storeGoodsAd/ad_update_page";
    }

    /**
     * 获取修改商品广告的添加广告页面
     * @param model
     * @return
     */
    @RequestMapping("/addAdPage")
    public String addadpage(Model model){
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.getBaseUrl());
        return "/store/storeGoodsAd/ad_add_page";
    }


    /**
     * 更新商品广告
     * @param storeGoodsAd
     * @return
     * @throws Exception
     */
    @RequestMapping("updateGoodsAd")
    @ResponseBody
    public Object updateGoodsAd(StoreGoodsAd storeGoodsAd) throws Exception{
        RestResult result = new RestResult();
        storeGoodsAdService.updateGoodsAd(storeGoodsAd);
        return result;
    }

    /**
     * @Description: 获取已有广告的商品信息
     * @Author: pangweichao
     * @Date: 14:37 2017/5/11
     * @Param: [draw, searchKey, orderColumn, orderType, page, pageSize]
     * @return: java.lang.Object
     */
    @RequestMapping("/getStoreGoodsWithAd")
    @ResponseBody
    public Object getStoreGoodsWithAd(@RequestParam("draw") int draw,
                                @RequestParam(value = "searchKey", required = false) String searchKey,
                                @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                @RequestParam(value = "orderType", required = false) String orderType,
                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        StoreMin storeMin = WebUtil.getCurrentStore();
        List<StoreGoodsDetailDTO> storeGoodsDetailDTOS = storeGoodsAdService.getStoreGoodsWithAd(searchKey,orderColumn,orderType,page,pageSize,storeMin.getStoreId());
        return new PageResult<StoreGoodsDetailDTO>(storeGoodsDetailDTOS,draw);
    }

    /**
     * 插入商品广告
     * @param storeGoodsAd
     * @return
     */
    @RequestMapping("/insertGoodsAd")
    @ResponseBody
    public Object insertGoodsAd(StoreGoodsAd storeGoodsAd) throws Exception{
        RestResult result = new RestResult();
        Integer info = storeGoodsAdService.insertGoodsAd(storeGoodsAd);
        return result;
    }

    /**
     * @Description: 获取没有广告的商品信息
     * @Author: pangweichao
     * @Date: 14:43 2017/5/11
     * @Param: []
     * @return: java.lang.Object
     */
    @RequestMapping("/getStoreGoodsWithoutAd")
    @ResponseBody
    public Object getStoreGoodsWithoutAd(){
        RestResult result = new RestResult();
        StoreMin storeMin = WebUtil.getCurrentStore();
        List<StoreGoodsDetailDTO> info = storeGoodsAdService.getStoreGoodsWithoutAd(storeMin.getStoreId());
        result.add("data",info);
        return result;
    }

}
