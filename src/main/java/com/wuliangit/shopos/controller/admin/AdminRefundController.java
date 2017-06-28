package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.StoreRefundListDTO;
import com.wuliangit.shopos.entity.Refund;
import com.wuliangit.shopos.service.RefundService;
import com.wuliangit.shopos.service.StoreRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wuliang01 on 2017/6/28.
 */
@Controller
@RequestMapping("/admin/refund")
public class AdminRefundController {

    @Autowired
    private RefundService refundService;

    @Autowired
    private StoreRefundService storeRefundService;

    @RequestMapping("/getRefundList")
    public String getRefundList(Model model){
        return "admin/refund/refund_list";
    }

    /**
     * @Description: 获取退换货列表的数据
     * @Author: pangweichao
     * @Date: 10:20 2017/5/12
     * @Param: [draw, searchKey, orderColumn, orderType, page, pageSize]
     * @return: java.lang.Object
     */
    @RequestMapping("/getAdminRefundList")
    @ResponseBody
    public Object getAdminRefundList(@RequestParam("draw") int draw,
                   @RequestParam(value = "searchKey", required = false) String searchKey,
                   @RequestParam(value = "orderColumn", required = false) String orderColumn,
                   @RequestParam(value = "orderType", required = false) String orderType,
                   @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<StoreRefundListDTO> storeRefundListDTOS = refundService.getAdminRefundList(searchKey,orderColumn,orderType,page,pageSize);
        return new PageResult<StoreRefundListDTO>(storeRefundListDTOS,draw);
    }

    @RequestMapping("/detailPage")
    public Object detailPage(Model model , Integer refundId , String storeName) throws Exception {
        Refund refund = storeRefundService.getRefundDetailInfo(refundId);
        model.addAttribute("refund",refund);
        model.addAttribute("store",storeName);
        return "/admin/refund/detail";
    }

}
