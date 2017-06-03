package com.wuliangit.shopos.controller;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import cn.jmessage.api.user.UserInfoResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.entity.GoodsSku;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.net.SMTPAppender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/3/21.
 */


@Controller
@RequestMapping("/test")
public class TestController {

    private static Log logger = LogFactory.getLog(TestController.class);

    @RequestMapping("/exception")
    public String exception(Integer a) throws Exception {
        logger.info("测试错误error");
        if (a==null){
            throw new Exception("测试错误");
        }
       return "admin/login";
    }

    @RequestMapping("/page1")
    public String page1(Model model){
        String token = QiNiuUtils.getToken();

        return "admin/testxx";
    }

    @RequestMapping("/test1")
    @ResponseBody
    public Object test1(String skus){
        RestResult result = new RestResult();
        System.out.println(skus);
        return result;
    }


}
