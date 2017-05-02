package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.service.MailService;
import com.wuliangit.shopos.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private SettingService settingService;


    /**
     * 邮件服务器设置界面
     * @return
     */
    @RequestMapping("/mailSettingPage")
    public String mailPage(){
        return "admin/setting/mail";
    }

    /**
     * 文件存储设置
     * @return
     */
    @RequestMapping("/bucketSettingPage")
    public String bucketSettingPage(Model model){
        model.addAttribute("accessKey",settingService.getSetting(QiNiuUtils.BUCKET_ACCESSKEY));
        model.addAttribute("secretKey",settingService.getSetting(QiNiuUtils.BUCKET_SECRETKEY));
        model.addAttribute("bucket",settingService.getSetting(QiNiuUtils.BUCKET_BUCKET));
        model.addAttribute("domain",settingService.getSetting(QiNiuUtils.BUCKET_DOMAIN));
        return "admin/setting/bucket";
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
        Integer info = settingService.updateMailSetting(mailServiceSite,mailUserName,mailPassword);
        if(info != 1){
            result.put("code",RestResult.CODE_SERVERERROR);
            result.put("msg",RestResult.MSG_ERROR);
        }
        return result;
    }

    /**
     * 更新文件存储配置
     * @param accessKey
     * @param secretKey
     * @param bucket
     * @param domain
     * @return
     */
    @RequestMapping("/updateBucketSetting")
    @ResponseBody
    public Object updateBucketSetting(String accessKey, String secretKey, String bucket, String domain){
        RestResult result = new RestResult();
        settingService.updateBucketSetting(accessKey,secretKey,bucket,domain);
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
