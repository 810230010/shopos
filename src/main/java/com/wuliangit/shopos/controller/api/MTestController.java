package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.WebUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * Created by nilme on 2017/3/21.
 */

@RestController
@RequestMapping("/api/v1/test")
public class MTestController {

    @RequestMapping("/api")
    public Object login(Integer a)  {
        RestResult result = new RestResult();

        System.out.println(a);

        return result;
    }

    public static void main(String[] args) {

        // 生成一个MD5加密计算摘要
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String signServer = base64en.encode(md5.digest("/api/v1/test/api?a=1&timestamp=123123123&token=e79fd3b742a0403f8c3a45090e82889e&userId=1".getBytes("utf-8")));

            System.out.println(signServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
