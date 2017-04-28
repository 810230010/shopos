package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.service.StoreJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by JangJanPing on 2017/4/27.
 * @description 管理员管理店铺Controller
 */

@Controller
@RequestMapping("/admin/store")
public class AdminStoreController {
    @Autowired
    private StoreJoinService storeJoinService;

    /**
     * 跳转到申请成为商家页面
     * @return
     */
    @RequestMapping("/storeListPage")
    public String listPage() {
        return "admin/store/list";
    }
    /**
     * 查询申请店铺列表
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
     * @param joininMessage
     * @Param memberId
     * @return
     */
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    @ResponseBody
    public Object updateJoininStoreStatus(String joininMessage, Integer memberId) {
        RestResult response = new RestResult();
        storeJoinService.updateRejectedJoininStoreStatus(joininMessage, memberId);
        return response;
    }
     
}
