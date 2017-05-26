package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.AdminDTO;
import com.wuliangit.shopos.dto.AdminRoleDTO;
import com.wuliangit.shopos.dto.MenuDTO;
import com.wuliangit.shopos.entity.AdminRole;
import com.wuliangit.shopos.service.AdminPermissionService;
import com.wuliangit.shopos.service.AdminRoleService;
import com.wuliangit.shopos.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JangJanPing on 2017/5/19.
 */
@Controller
@RequestMapping("/admin/role")
public class AdminRoleController {
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminPermissionService adminPermissionService;

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
    public String addRolePage(Model model){
        return "/admin/authority/add_role";
    }

    /**
     * 查询所有管理员角色列表
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/searchRoleList")
    @ResponseBody
    public Object searchRoleList(@RequestParam("draw") int draw,
                                 @RequestParam(value = "searchKey", required = false) String searchKey,
                                 @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                 @RequestParam(value = "orderType", required = false) String orderType,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<AdminRoleDTO> list = adminRoleService.searchAdminRoleList(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult<AdminRoleDTO>(list, draw);
    }

    /**
     * 删除管理员
     * @param adminRoleId
     * @return
     */
    @RequestMapping("/deleteRole")
    @ResponseBody
    public Object deleteRole(Integer adminRoleId){
        RestResult result = new RestResult();
        if(adminRoleService.deleteRole(adminRoleId) != 1){
            result = new RestResult("未知错误", 502);
            return result;
        }
        return result;
    }

    /**
     * 获得所有角色
     * @return
     */
    @RequestMapping("/getAllRoles")
    @ResponseBody
    public Object getAllRoles(){
        RestResult result = new RestResult();
        ArrayList<AdminRoleDTO> roleList = adminService.getAllAdminRoles();
        result.add("roleList",roleList);
        return result;
    }


    /**
     * 管理员角色详情页面
     * @return
     */
    @RequestMapping("/adminRoleDetailPage")
    public String scanAdminRoleDetailPage(Model model, Integer roleId){
        AdminRoleDTO adminRoleDTO = adminRoleService.getAdminRoleDetail(roleId);
        model.addAttribute("adminRoleDetail", adminRoleDTO);
        return "/admin/authority/role_detail";
    }

    /**
     * 管理员编辑角色信息页面
     * @param adminRoleId
     * @return
     */
    @RequestMapping("/adminEditRolePage")
    public String editRole(Model model, Integer adminRoleId){
        AdminRoleDTO adminRoleDTO = adminRoleService.getAdminRoleDetail(adminRoleId);
        model.addAttribute("adminRoleDetail", adminRoleDTO);
        model.addAttribute("permissionList", adminPermissionService.getPermissionByRoleId(adminRoleId));
        return "/admin/authority/edit_role";
    }

    /**
     * 添加管理员角色
     * @param adminRole
     * @return
     */
    @RequestMapping("/adminAddRole")
    @ResponseBody
    public Object addAdminRole(AdminRole adminRole){
        RestResult result = new RestResult();
        if(adminRoleService.addAdminRole(adminRole) != 1){
            result = new RestResult("未知错误,添加失败", 502);
            return result;
        }
        return result;
    }

    /**
     * 管理员修改角色信息
     * @param adminRole
     * @return
     */
    @RequestMapping("/adminEditRole")
    @ResponseBody
    public Object editAdminRole(AdminRole adminRole){
        RestResult result = new RestResult();
        if(adminRoleService.updateAdminRole(adminRole) != 1){
            result = new RestResult("未知错误,修改失败", 502);
            return result;
        }
        return result;
    }
}
