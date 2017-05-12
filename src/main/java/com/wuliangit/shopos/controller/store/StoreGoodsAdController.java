package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.dto.TuikeCheckListDTO;
import com.wuliangit.shopos.entity.StoreGoodsAd;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.StoreGoodsAdService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/5/8.
 */
@Controller
@RequestMapping("/store/goodsAd")
public class StoreGoodsAdController {

    @Autowired
    private StoreGoodsAdService storeGoodsAdService;

    @Autowired
    private GoodsService goodsService;

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
        StoreUser storeUser = WebUtil.getCurrentStore();
        List<StoreGoodsDetailDTO> storeGoodsDetailDTOS = storeGoodsAdService.getStoreGoodsWithAd(searchKey,orderColumn,orderType,page,pageSize,storeUser.getStoreId());
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
        StoreUser storeUser = WebUtil.getCurrentStore();
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
        StoreUser storeUser = WebUtil.getCurrentStore();
        List<StoreGoodsDetailDTO> info = storeGoodsAdService.getStoreGoodsWithoutAd(storeUser.getStoreId());
        result.put("data",info);
        return result;
    }

}
