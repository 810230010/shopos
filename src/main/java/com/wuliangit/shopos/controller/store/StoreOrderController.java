package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.util.StringUtils;
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
 * @author pangweichao
 * @description 店铺订单
 * @create 2017-05-11 16:55
 **/
@Controller
@RequestMapping("/store/order")
public class StoreOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @Description: 获取订单列表页面
     * @Author: pangweichao
     * @Date: 17:29 2017/5/11
     * @Param: [model, type]
     * @return: java.lang.String
     */
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "type", required = false) Integer type){
        model.addAttribute("type",type);
        return "/store/order/list";
    }

    /**
     * @Description: 获取订单详情
     * @Author: pangweichao
     * @Date: 21:54 2017/5/11
     * @Param: [model, orderId]
     * @return: java.lang.String
     */
    @RequestMapping("/detail")
    public String detail(Model model,Integer orderId){
        Order order = orderService.getOrderDetail(orderId);
        model.addAttribute("order",order);
        return "/store/order/detail";
    }

    /**
     * @Description: 已取消订单列表页面
     * @Author: pangweichao
     * @Date: 22:34 2017/5/11
     * @Param: [model, type]
     * @return: java.lang.String
     */
    @RequestMapping("/cancellist")
    public String cancellist(Model model,@RequestParam(value = "type", required = false) Integer type){
        model.addAttribute("type",type);
        return "/store/order/cancel_list";
    }

    /**
     * @Description: 商铺获取订单列表数据
     * @Author: pangweichao
     * @Date: 20:48 2017/5/11
     * @Param: [draw, searchKey, orderColumn, orderType, page, pageSize, type]
     * @return: java.lang.Object
     */
    @RequestMapping("/getStoreOrderList")
    @ResponseBody
    public Object getStoreOrderList(@RequestParam("draw") int draw,
                               @RequestParam(value = "searchKey", required = false) String searchKey,
                               @RequestParam(value = "orderColumn", required = false) String orderColumn,
                               @RequestParam(value = "orderType", required = false) String orderType,
                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(value = "type", required = false) Integer type){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<StoreOrderListDTO> storeOrderListDTOS = orderService.getStoreOrderList(searchKey,orderColumn,orderType,page,pageSize,type);
        return new PageResult<StoreOrderListDTO>(storeOrderListDTOS,draw);
    }

}
