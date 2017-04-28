package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.service.StoreJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/storeListPage")
    public String listPage() {
        return "admin/store/list";
    }
    /**
     * 查询申请店铺列表
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public Object search(@RequestParam("draw") int draw,
                         @RequestParam(value = "searchKey", required = false) String searchKey,
                         @RequestParam(value = "orderColumn", required = false) String orderColumn,
                         @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        ArrayList<StoreJoinin> stores = storeJoinService.getJoinStores(page, pageSize, searchKey, orderColumn);
        return new PageResult<StoreJoinin>(stores, draw);
    }


     
}
