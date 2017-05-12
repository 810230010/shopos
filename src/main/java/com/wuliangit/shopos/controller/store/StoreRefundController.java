package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.StoreRefundListDTO;
import com.wuliangit.shopos.service.StoreRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author pangweichao
 * @description 退换货相关操作
 * @create 2017-05-12 9:51
 **/
@Controller
@RequestMapping("/store/refund")
public class StoreRefundController {

    @Autowired
    private StoreRefundService storeRefundService;

    /**
     * @Description: 获取申请退换货列表的页面
     * @Author: pangweichao
     * @Date: 10:17 2017/5/12
     * @Param: [model]
     * @return: java.lang.String
     */
    @RequestMapping("/refundList")
    public String refundList(Model model){
        return "/store/refund/applyrefundlist";
    }

    /**
     * @Description: 获取退换货申请列表的数据
     * @Author: pangweichao
     * @Date: 10:20 2017/5/12
     * @Param: [draw, searchKey, orderColumn, orderType, page, pageSize]
     * @return: java.lang.Object
     */
    @RequestMapping("/getApplyRefundList")
    @ResponseBody
    public Object getApplyRefundList(@RequestParam("draw") int draw,
                                     @RequestParam(value = "searchKey", required = false) String searchKey,
                                     @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                     @RequestParam(value = "orderType", required = false) String orderType,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<StoreRefundListDTO> storeRefundListDTOS = storeRefundService.getApplyRefundList(searchKey,orderColumn,orderType,page,pageSize);
        return new PageResult<StoreRefundListDTO>(storeRefundListDTOS,draw);
    }

    /**
     * @Description: 审核退换货的申请
     * @Author: pangweichao
     * @Date: 10:52 2017/5/12
     * @Param: [refundId, sellerState]
     * @return: com.wuliangit.shopos.common.controller.RestResult
     */
    @RequestMapping("/checkRefundApply")
    @ResponseBody
    public RestResult checkRefundApply(Integer refundId,String sellerState) throws Exception{
        RestResult result = new RestResult();
        Integer info = storeRefundService.checkRefundApply(refundId,sellerState);
        return result;
    }

}
