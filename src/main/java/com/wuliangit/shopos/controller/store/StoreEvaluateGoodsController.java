package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.EvaluateGoodsListDTO;
import com.wuliangit.shopos.dto.StoreEvaluateGoodsDetailDTO;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.EvaluateGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author boom
 * @description 商品评论相关接口
 * @create 2017-05-26 16:53
 **/
@RequestMapping("/store/evaluateGoods")
@Controller
public class StoreEvaluateGoodsController {

    @Autowired
    private EvaluateGoodsService evaluateGoodsService;

    /**
     * @Description: 获取商品评价列表页面
     * @Author: pangweichao
     * @Date: 16:55 2017/5/26
     * @Param: [model]
     * @return: java.lang.String
     */
    @RequestMapping("/listPage")
    public String listPage(Model model){
        return "/store/evaluate/list";
    }

    /**
     * @Description: 获取商品评价列表页面的数据
     * @Author: pangweichao
     * @Date: 17:19 2017/5/26
     * @Param: [draw, searchKey, orderColumn, orderType, page, pageSize]
     * @return: java.lang.Object
     */
    @RequestMapping("/getEvaluateGoodsListInfo")
    @ResponseBody
    public Object getEvaluateGoodsListInfo(@RequestParam("draw") int draw,
                                           @RequestParam(value = "searchKey", required = false) String searchKey,
                                           @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                           @RequestParam(value = "orderType", required = false) String orderType,
                                           @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        StoreMin store = WebUtil.getCurrentStore();
        List<EvaluateGoodsListDTO> evaluateGoodsListDTOS = evaluateGoodsService.getEvaluateGoodsListInfo(searchKey,orderColumn,orderType,page,pageSize,store.getStoreId());
        return new PageResult<EvaluateGoodsListDTO>(evaluateGoodsListDTOS,draw);
    }

    /**
     * @Description: 获取某条商品评论的详情
     * @Author: pangweichao
     * @Date: 22:04 2017/5/27
     * @Param: [evaluateGoodsId]
     * @return: java.lang.Object
     */
    @RequestMapping("/getEvaluateGoodsDetail")
    @ResponseBody
    public Object getEvaluateGoodsDetail(Integer evaluateGoodsId){
        RestResult result = new RestResult();
        StoreEvaluateGoodsDetailDTO detail = evaluateGoodsService.getEvaluateGoodsDetail(evaluateGoodsId);
        result.add("data",detail);
        return result;
    }

}
