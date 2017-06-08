package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.dto.SettingDTO;
import com.wuliangit.shopos.model.SysSetting;
import com.wuliangit.shopos.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by pangweichao on 2017/4/30.
 */
@Controller
@RequestMapping("/admin/setting")
public class AdminSettingController {

    @Autowired
    private SettingService settingService;


    /**
     * 邮件服务器设置界面
     *
     * @return
     */
    @RequestMapping("/mailSettingPage")
    public String mailPage() {
        return "admin/setting/mail";
    }

    /**
     * 文件存储设置
     *
     * @return
     */
    @RequestMapping("/bucketSettingPage")
    public String bucketSettingPage(Model model) {
        model.addAttribute("accessKey", settingService.getSetting(QiNiuUtils.BUCKET_ACCESSKEY));
        model.addAttribute("secretKey", settingService.getSetting(QiNiuUtils.BUCKET_SECRETKEY));
        model.addAttribute("bucket", settingService.getSetting(QiNiuUtils.BUCKET_BUCKET));
        model.addAttribute("domain", settingService.getSetting(QiNiuUtils.BUCKET_DOMAIN));
        return "admin/setting/bucket";
    }

    /**
     * 更新邮箱设置
     *
     * @param mailServiceSite
     * @param mailUserName
     * @param mailPassword
     * @return
     */
    @RequestMapping("/updateMail")
    @ResponseBody
    public RestResult updateMail(String mailServiceSite, String mailUserName, String mailPassword) {
        RestResult result = new RestResult();
        Integer info = settingService.updateMailSetting(mailServiceSite, mailUserName, mailPassword);
        if (info != 1) {
            result.add("code", RestResult.CODE_SERVERERROR);
            result.add("msg", RestResult.MSG_ERROR);
        }
        return result;
    }

    /**
     * 更新文件存储配置
     *
     * @param accessKey
     * @param secretKey
     * @param bucket
     * @param domain
     * @return
     */
    @RequestMapping("/updateBucketSetting")
    @ResponseBody
    public Object updateBucketSetting(String accessKey, String secretKey, String bucket, String domain) {
        RestResult result = new RestResult();
        settingService.updateBucketSetting(accessKey, secretKey, bucket, domain);
        return result;
    }

    /**
     * 支付设置页面
     *
     * @return
     */
    @RequestMapping("/paySettingPage")
    public String paySettingPage(Model model) {
        model.addAttribute("alipayPublicKey", settingService.getSetting(AliPay.ALIPAY_PUBLIC_KEY));
        model.addAttribute("appId", settingService.getSetting(AliPay.ALIPAY_APP_ID));
        model.addAttribute("appPrivateKey", settingService.getSetting(AliPay.ALIPAY_APP_PRIVATE_KEY));
        model.addAttribute("alipayCheck", settingService.getSetting(AliPay.ALIPAY_CHECK));
        return "admin/setting/pay";
    }

    /**
     * 支付宝设置更新
     *
     * @return
     */
    @RequestMapping("/updateAliPaySetting")
    @ResponseBody
    public Object updateAliPaySetting(String alipayPublicKey, String appId, String appPrivateKey,String alipayCheck) {
        RestResult result = new RestResult();
        settingService.updatePaySetting(alipayPublicKey, appId, appPrivateKey, alipayCheck);
        return result;
    }

    /**
     * 获取邮箱设置的各项参数
     * @return
     */
    @RequestMapping("/getMailSetting")
    @ResponseBody
    public Object getMailSetting(){
        RestResult result = new RestResult();
        List<SettingDTO> info = settingService.getMailSetting();
        if(info == null){
            result.add("code",RestResult.CODE_SERVERERROR);
            result.add("msg",RestResult.MSG_ERROR);
        }else{
            result.add("data",info);
        }
        return result;
    }

    /**
     * 获取邮箱设置的各项参数
     * @return
     */
    @RequestMapping("/sysSettingPage")
    public String sysSettingPage(Model model){
        SysSetting sysSetting = settingService.getSysSetting();
        model.addAttribute("name",sysSetting.getName());
        model.addAttribute("title",sysSetting.getTitle());
        model.addAttribute("key",sysSetting.getKey());
        model.addAttribute("description",sysSetting.getDescription());
        model.addAttribute("qq",sysSetting.getQq());

        return "admin/setting/sys";
    }


    /**
     * 更新系统设置
     * @param sysSetting
     * @return
     */
    @RequestMapping("/updateSysSetting")
    @ResponseBody
    public Object updateAliPaySetting(SysSetting sysSetting) {
        RestResult result = new RestResult();
        settingService.updateSysSetting(sysSetting);
        return result;
    }

}
