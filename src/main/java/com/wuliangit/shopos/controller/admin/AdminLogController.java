package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.entity.AdminLog;
import com.wuliangit.shopos.service.AdminLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 管理员日志
 * Created by nilme on 2017/5/15.
 */

@Controller
@RequestMapping("/admin/log")
public class AdminLogController {

    @Autowired
    private AdminLogService adminLogService;

    /**
     * 跳转到所有管理员页面
     * @return
     */
    @RequestMapping("/adminLogPage")
    public String allAdminListPage(){
        return "admin/log/list";
    }

    @RequestMapping("/adminLogList")
    @ResponseBody
    public Object searchAdminList(@RequestParam("draw") int draw,
                                  @RequestParam(value = "searchKey", required = false) String searchKey,
                                  @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                  @RequestParam(value = "orderType", required = false) String orderType,
                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        List<AdminLog> info = adminLogService.getAdminLogList(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult<AdminLog>(info,draw);
    }

}
