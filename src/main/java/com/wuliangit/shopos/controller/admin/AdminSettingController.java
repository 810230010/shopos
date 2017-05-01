package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 26229 on 2017/4/30.
 */
@Controller
@RequestMapping("/admin/setting")
public class AdminSettingController {

    @Autowired
    private MailService mailService;

    @RequestMapping("/mailPage")
    public String mailPage(){
        return "admin/setting/mail";
    }

    /**
     * 更新邮箱设置
     * @param mailServiceSite
     * @param mailUserName
     * @param mailPassword
     * @return
     */
    @RequestMapping("/updateMail")
    @ResponseBody
    public RestResult updateMail(String mailServiceSite, String mailUserName, String mailPassword){
        RestResult result = new RestResult();
        Integer info = mailService.updateMail(mailServiceSite,mailUserName,mailPassword);
        if(info != 1){
            result.put("code",RestResult.CODE_SERVERERROR);
            result.put("msg",RestResult.MSG_ERROR);
        }
        return result;
    }

    /**
     * 测试邮件的发送
     * @param user
     * @param templt
     * @return
     */
    @RequestMapping(value = "/testSend", method = RequestMethod.POST)
    @ResponseBody
    public RestResult testSend(String user, String templt){
        RestResult result = new RestResult();
        mailService.sendMail(user,templt);
        return result;
    }

}
