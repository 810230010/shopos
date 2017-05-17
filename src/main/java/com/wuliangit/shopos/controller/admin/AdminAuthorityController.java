package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 江建平 on 2017/5/12.
 * @description 管理员权限控制器
 */
@Controller
@RequestMapping("/admin/authority")
public class AdminAuthorityController {

    /**
     * 管理员列表页面
     * @return
     */
    @RequestMapping("/adminListPage")
    public String allAdminListPage(){
        return "admin/authority/admin_list";
    }

    /**
     * 管理员添加页面
     * @return
     */
    @RequestMapping("/addAdminPage")
    public String addAdminPage(){
        return "/admin/authority/add_admin";
    }

    /**
     * 角色列表页面
     * @return
     */
    @RequestMapping("/roleListPage")
    public String roleListPage(){
        return "/admin/authority/role_list";
    }

    /**
     * 添加角色页面
     * @return
     */
    @RequestMapping("/addRolePage")
    public String addRolePage(){
        return "/admin/authority/add_role";
    }
    /**
     *
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/searchAdminList")
    @ResponseBody
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
