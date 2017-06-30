package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.api.ApiOrderGoodsDTO;
import com.wuliangit.shopos.dto.StoreOrderListDTO;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.service.OrderService;
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
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderListPage")
    public String orderListPage(Model model){
        return "admin/order/order_list";
    }

    @RequestMapping("/detailPage")
    public String detailPage(Model model, Integer orderId){
        Order order = orderService.getOrderDetail(orderId);
        List<ApiOrderGoodsDTO> goodses = orderService.getOrderDetailGoods(orderId);

        model.addAttribute("order", order);
        model.addAttribute("goodses", goodses);
        return "admin/order/detail_page";
    }

    @RequestMapping("/cancleOrderList")
    public String cancleOrderList(Model model){
        return "admin/order/cancle_order_list";
    }

    /**
     * 获得所有订单的数据
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @param state
     * @return
     */
    @RequestMapping("/getOrderList")
    @ResponseBody
    public Object getOrderList(@RequestParam("draw") int draw,
                               @RequestParam(value = "searchKey", required = false) String searchKey,
                               @RequestParam(value = "orderColumn", required = false) String orderColumn,
                               @RequestParam(value = "orderType", required = false) String orderType,
                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(value = "state", required = false) String state){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<StoreOrderListDTO> storeOrderListDTOS = orderService.getAdminOrderList(searchKey, orderColumn, orderType, page, pageSize, state);
        return new PageResult<StoreOrderListDTO>(storeOrderListDTOS, draw);
    }

}
