package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.StoreAccountListDTO;
import com.wuliangit.shopos.dto.StoreCashListDTO;
import com.wuliangit.shopos.service.StoreAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author boom
 * @description 商户账户和佣金相关接口
 * @create 2017-06-02 9:47
 **/
@Controller
@RequestMapping("/admin/storeAccount")
public class AdminStoreAccountController {

    @Autowired
    private StoreAccountService storeAccountService;

    @RequestMapping("/storeAccountListPage")
    public String storeAccountListPage(Model model){
        return "admin/storeAccount/account_list";
    }

    @RequestMapping("/storeCashListPage")
    public String storeCashListPage(Model model){
        return "admin/storeAccount/cash_list";
    }

    /**
     * @Description: 获取商家账户管理页面list数据
     * @Author: pangweichao
     * @Date: 10:08 2017/6/2
     * @Param: [page, pageSize, draw, orderColumn, orderType, searchKey]
     * @return: java.lang.Object
     */
    @RequestMapping("getStoreAccountListDate")
    @ResponseBody
    public Object getStoreAccountListDate(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page,
                                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(value = "draw",required = false) Integer draw,
                                          @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                          @RequestParam(value = "orderType", required = false) String orderType,
                                          @RequestParam(value = "searchKey", required = false) String searchKey){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<StoreAccountListDTO> info = storeAccountService.getStoreAccountListDate(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult(info,draw);
    }

    /**
     * @Description: 获取订单佣金管理
     * @Author: pangweichao
     * @Date: 10:08 2017/6/2
     * @Param: [page, pageSize, draw, orderColumn, orderType, searchKey]
     * @return: java.lang.Object
     */
    @RequestMapping("getCashListDate")
    @ResponseBody
    public Object getCashListDate(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page,
                                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(value = "draw",required = false) Integer draw,
                                          @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                          @RequestParam(value = "orderType", required = false) String orderType,
                                          @RequestParam(value = "searchKey", required = false) String searchKey){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<StoreCashListDTO> info = storeAccountService.getCashListDate(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult(info,draw);
    }

}
