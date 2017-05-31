package com.wuliangit.shopos.controller.store;

import com.alipay.api.AlipayApiException;
import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.entity.StoreAccount;
import com.wuliangit.shopos.entity.StoreAccountLog;
import com.wuliangit.shopos.entity.StoreCash;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.StoreAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by nilme on 2017/5/27.
 */

@Controller
@RequestMapping("/store/account")
public class StoreAccountController {

    @Autowired
    private StoreAccountService storeAccountService;

    @RequestMapping("/accountHistory")
    public String accountHistoryPage(){
        return "store/account/history_list";
    }

    /**
     * 店铺资金流水记录
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/accountHistoryList")
    @ResponseBody
    public Object accountHistoryList(@RequestParam("draw") int draw,
                                     @RequestParam(value = "searchKey", required = false) String searchKey,
                                     @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                     @RequestParam(value = "orderType", required = false) String orderType,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<StoreAccountLog> storeAccountLogList = storeAccountService.getAccountHistoryList(page, pageSize, orderColumn, orderType);
        return new PageResult<>(storeAccountLogList, draw);
    }


    @RequestMapping("/cashHistory")
    public String cashHistoryPage(){
        return "store/account/cash_list";
    }

    /**
     * 店铺资金流水记录
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/cashHistoryList")
    @ResponseBody
    public Object cashHistoryList(@RequestParam("draw") int draw,
                                     @RequestParam(value = "searchKey", required = false) String searchKey,
                                     @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                     @RequestParam(value = "orderType", required = false) String orderType,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<StoreCash> storeCashList = storeAccountService.getCashHistoryList(page, pageSize, orderColumn, orderType);
        return new PageResult<>(storeCashList, draw);
    }

    /**
     * 提现页面
     * @return
     */
    @RequestMapping(value = "/cash",method = RequestMethod.GET)
    public String cashPage(Model model){
        StoreAccount storeAccount = storeAccountService.getStoreAccount();
        model.addAttribute("storeAccount",storeAccount);
        return "store/account/cash";
    }

    /**
     * 店铺支付宝提现
     * @param amount
     * @return
     * @throws OptionException
     */
    @RequestMapping(value = "/cash",method = RequestMethod.POST)
    @ResponseBody
    public Object doCash(BigDecimal amount) throws OptionException, AlipayApiException {
        RestResult result = new RestResult();
        int res = storeAccountService.storeDoCash(amount);
        return result;
    }

    /**
     * 提现页面
     * @return
     */
    @RequestMapping(value = "/settingAlipay",method = RequestMethod.POST)
    public String settingAlipay(Model model,String alipayAccount){
        StoreMin store = WebUtil.getCurrentStore();
        int res = storeAccountService.settingStoreAlipay(alipayAccount);
        StoreAccount storeAccount = storeAccountService.getStoreAccount();
        model.addAttribute("storeAccount",storeAccount);
        model.addAttribute("storeName",store.getName());
        return "store/account/cash";
    }
}
