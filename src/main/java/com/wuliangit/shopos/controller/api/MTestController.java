package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        String signUrl = new Md5Hash("/api/v1/?code=1&timestamp=1491275623230&token=0&userId=0").toString();
        System.out.println(signUrl);
    }

}
