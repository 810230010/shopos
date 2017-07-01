package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by JangJanPing on 2017/7/1.
 * @description 管理云公约管理控制器
 */
@Controller
@RequestMapping("/admin/regulation")
public class AdminRegulationController {

    @Autowired
    private SettingService settingService;

    /**
     * 跳转到注册公约添加/修改页面
     * @param model
     * @return
     */
    @RequestMapping("/registerRegulation")
    public String view2RegulationPage(Model model){
         model.addAttribute("regulationContent", settingService.getRegisterRegulation());
         return "admin/regulation/regulation_registery_edit";
    }

    /**
     * 修改注册公约
     * @param regulationContent
     * @return
     */
    @RequestMapping("/updateRegisteryRegulation")
    @ResponseBody
    public Object updateRegulationContent(String regulationContent){
        RestResult result = null;
        if(settingService.updateRegulationContent(regulationContent) != 1){
            result = new RestResult("未知错误", 405);
        }else{
            result = new RestResult();
        }
        return result;
    }
}
