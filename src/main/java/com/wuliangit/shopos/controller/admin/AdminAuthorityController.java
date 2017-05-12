package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 江建平 on 2017/5/12.
 * @description 管理员权限控制器
 */
@RequestMapping("/admin/authority")
public class AdminAuthorityController {

    /**
     * 跳转到所有管理员页面
     * @return
     */
    @RequestMapping("/allAdminListPge")
    public String jumpToAllAdminList(){
        return "admin/authority/all_admin_list";
    }

    @RequestMapping("/searchAdminList")
    public Object searchAdminList(@RequestParam("draw") int draw,
                                  @RequestParam(value = "searchKey", required = false) String searchKey,
                                  @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                  @RequestParam(value = "orderType", required = false) String orderType,
                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        return null;
    }
}
