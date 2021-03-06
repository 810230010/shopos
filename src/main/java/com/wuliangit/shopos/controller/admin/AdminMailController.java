package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.StoreMessageDTO;
import com.wuliangit.shopos.service.MailService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author boom
 * @description 邮件相关的操作
 * @create 2017-05-18 16:41
 **/
@Controller
@RequestMapping("/admin/mail")
public class AdminMailController {

    @Autowired
    private MailService mailService;

    /**
     * @Description: 获取发送邮件界面
     * @Author: pangweichao
     * @Date: 16:44 2017/5/18
     * @Param: [model]
     * @return: java.lang.String
     */
    @RequestMapping("/sendMessagePage")
    public String sendMessagePage(Model model){
        return "/admin/mail/send_mail";
    }

    /**
     * @Description: 发送邮件
     * @Author: pangweichao
     * @Date: 14:37 2017/5/19
     * @Param: [recipient, title, content]
     * @return: java.lang.Object
     */
    @RequestMapping("sendMail")
    @ResponseBody
    public Object sendMail(StoreMessageDTO storeMessageDTO){
        RestResult result = new RestResult();
        String info = mailService.sendMail(storeMessageDTO);
        if(info.equals("error")){
            result.add("code",RestResult.CODE_SERVERERROR);
            result.add("msg",RestResult.MSG_ERROR);
        }
        return result;
    }

}
