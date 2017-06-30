package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.api.ApiOrderGoodsDTO;
import com.wuliangit.shopos.dto.StoreOrderListDTO;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nilme on 2017/5/27.
 */

@RestController
@RequestMapping(value = "/api/v1/seller/order")
public class MSellerOrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 填写物流信息
     * @param expressName
     * @param expressNo
     * @param orderId
     * @return
     */
    @RequestMapping("/express")
    public Object addExpressInfo(String expressName, String expressCode, String expressNo, Integer orderId) throws OptionException {
        RestResult result = new RestResult();
        int res = orderService.apiAddExpressInfo(expressName,expressCode, expressNo, orderId);
        return result;
    }

    /**
     * 获取订单详情
     * @param orderId
     * @return
     */
    @RequestMapping("/detail")
    public Object detail(Integer orderId) {
        RestResult result = new RestResult();

        Order order = orderService.getOrderDetail(orderId);
        List<ApiOrderGoodsDTO> goodses = orderService.getOrderDetailGoods(orderId);

        result.add("order", order);
        result.add("goodses", goodses);

        return result;
    }

    /**
     * 商铺获取订单列表数据
     * @param page
     * @param pageSize
     * @param state   已取消 CANCEL,创建未付款 INIT,已付款 PAYED,已发货 DELIVE,已收货 RECEIVE,已收货 RECEIVE,已退款 REFUND
     * @return
     */
    @RequestMapping("/getStoreOrderList")
    public Object getStoreOrderList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "state", required = false) String state) {
        List<StoreOrderListDTO> storeOrderListDTOS =  orderService.apiGetStoreOrderList(page, pageSize, state);
        return storeOrderListDTOS;

    }

}
