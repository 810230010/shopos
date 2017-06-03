package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.PasswordHelper;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.StoreDetailDTO;
import com.wuliangit.shopos.dto.AdminMailToSelectDTO;
import com.wuliangit.shopos.dto.StorePageListDTO;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.service.SellerService;
import com.wuliangit.shopos.service.StoreAccountService;
import com.wuliangit.shopos.service.StoreJoinService;
import com.wuliangit.shopos.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JangJanPing on 2017/4/27.
 *
 * @description 管理员管理店铺Controller
 */

@Controller
@RequestMapping("/admin/store")
public class AdminStoreController {
    @Autowired
    private StoreJoinService storeJoinService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private StoreAccountService storeAccountService;

    /**
     * 申请成为商家页面
     *
     * @return
     */
    @RequestMapping("/applyListPage")
    public String applyListPage() {
        return "admin/store/apply_list";
    }

    /**
     * 商家列表页面
     *
     * @return
     */
    @RequestMapping("/storeListPage")
    public String storeListPage() {
        return "admin/store/store_list";
    }

    /**
     * 商家列表页面
     *
     * @return
     */
    @RequestMapping("/storeAddPage")
    public String storeAddPage() {
        return "admin/store/store_add";
    }

    /**
     * 查询申请店铺列表
     *
     * @param draw
     * @param searchKey
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public Object search(@RequestParam("draw") int draw,
                         @RequestParam(value = "searchKey", required = false) String searchKey,
                         @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        ArrayList<StoreJoinin> stores = storeJoinService.getJoinStores(page, pageSize, searchKey);
        return new PageResult<StoreJoinin>(stores, draw);
    }

    /**
     * 审批不通过
     *
     * @param joininMessage
     * @return
     * @Param memberId
     */
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    @ResponseBody
    public Object updateJoininStoreStatus(String joininMessage, Integer memberId) {
        RestResult response = new RestResult();
        storeJoinService.updateRejectedJoininStoreStatus(joininMessage, memberId);
        return response;
    }

    /**
     * 入驻商家申请通过
     *
     * @param memberId
     * @return
     */
    @RequestMapping(value = ("/pass"), method = RequestMethod.POST)
    @ResponseBody
    public Object passApplyForJoininStore(Integer memberId) {
        RestResult result = new RestResult();
        storeJoinService.passApplyForJoininStore(memberId);
        return result;
    }

    /**
     * 进入申请入驻店铺的详细信息
     *
     * @param memberId
     * @param model
     * @return
     */
    @RequestMapping("/applyDetailPage")
    public String jumpToStoreJoininDetail(Integer memberId, Model model) {
        StoreJoinin store = storeJoinService.getStoreJoininDetail(memberId);
        model.addAttribute("store", store);
        return "/admin/store/apply_detail";
    }

    /**
     * 获取商家列表数据
     *
     * @param page
     * @param pageSize
     * @param draw
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    @RequestMapping("/getStoreList")
    @ResponseBody
    public PageResult getStoreList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                   @RequestParam("draw") Integer draw,
                                   @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                   @RequestParam(value = "orderType", required = false) String orderType,
                                   @RequestParam(value = "searchKey", required = false) String searchKey) {
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<StorePageListDTO> result = storeService.getStoreList(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult<StorePageListDTO>(result, draw);
    }

    /**
     * 更改店铺状态
     *
     * @param storeId
     * @param state
     * @return
     */
    @RequestMapping("/updateStoreState")
    @ResponseBody
    public Object updateStoreState(Integer storeId, String state) {
        RestResult result = new RestResult();
        Integer info = storeService.updateStoreState(storeId, state);
        if (info != 1) {
            result.put("code", RestResult.CODE_SERVERERROR);
            result.put("msg", RestResult.MSG_ERROR);
        }
        return result;
    }

    /**
     * @Description: 获取商家详情
     * @Author: pangweichao
     * @Date: 16:15 2017/5/16
     * @Param: [storeId, model]
     * @return: java.lang.String
     */
    @RequestMapping("/getStoreDetailInfo")
    public String getStoreDetailInfo(Integer storeId, Model model) {
        StoreDetailDTO info = storeService.getStoreDetailInfo(storeId);
        model.addAttribute("store", info);
        return "/admin/store/store_detail";
    }


    /**
     * 添加店铺
     * @param storeName
     * @param storeCompanyName
     * @param storeType
     * @param sellerUsername
     * @param password
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Object add(String storeName, String storeCompanyName,
                      String storeType, String sellerUsername, String password) {
        RestResult result = new RestResult();

        Store store = new Store();
        store.setName(storeName);
        store.setStoreCompanyName(storeCompanyName);
        store.setType(storeType);
        storeService.createStore(store);

        Seller seller = new Seller();
        seller.setUsername(sellerUsername);
        seller.setSalt(PasswordHelper.generateSalt());
        seller.setPassword(PasswordHelper.generatePassword(password, seller.getSalt()));
        seller.setIsAdmin(true);
        seller.setSellerRoleId(1);
        seller.setStoreId(store.getStoreId());
        seller.setLastLoginTime(new Date());
        sellerService.createSeller(seller);

        storeAccountService.createStoreAccount(store.getStoreId());

        return result;
    }

    /**
     * @Description: 获取所有的商铺
     * @Author: pangweichao
     * @Date: 12:22 2017/6/3
     * @Param: []
     * @return: java.lang.Object
     */
    @RequestMapping("getAllStore")
    @ResponseBody
    public Object getAllStore(){
        RestResult result = new RestResult();
        List<AdminMailToSelectDTO> adminMailToSelectDTOS = storeService.getAllStore();
        result.put("data", adminMailToSelectDTOS);
        return result;
    }

}
