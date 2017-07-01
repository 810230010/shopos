package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.GoodsDetailDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/4/10.
 */

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品列表页面
     * @return
     */
    @RequestMapping("/list")
    public String listPage(){
        return "admin/goods/list";
    }

    /**
     * 管理员得到所有商品
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/getAllGoods")
    @ResponseBody
    public Object adminGetAllGoods(@RequestParam("draw") int draw,
                                   @RequestParam(value = "searchKey", required = false) String searchKey,
                                   @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                   @RequestParam(value = "orderType", required = false) String orderType,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<Goods> goods = goodsService.adminGetAllGoodsSearch(page, pageSize, searchKey, orderColumn, orderType);
        return new PageResult<Goods>(goods, draw);
    }

    /**
     * 管理员更改商品申请状态
     * @param goodsId
     * @param reason
     * @param type 0:拒绝   1:通过  2:推荐到首页 3：下架
     * @return
     */
    @RequestMapping("/adminUpdateGoodsApply")
    @ResponseBody
    public Object adminUpdateGoodsApply(Integer goodsId, String reason, Integer type){
         RestResult result = null;
         if(goodsService.adminUpdateGoodsApplyStatus(goodsId, reason, type) != 1){
             result = new RestResult("未知错误", 405);
         }else{
             result = new RestResult();
         }
         return result;
    }

    /**
     * 商品详情页
     * @param goodsId
     * @return
     */
    @RequestMapping("/goodsDetailPage")
    public String view2GoodsDetail(Integer goodsId, Model model){
        model.addAttribute("goods", goodsService.adminGetGoodsDetail(goodsId));
       return "admin/goods/goods_detail";
    }
}
