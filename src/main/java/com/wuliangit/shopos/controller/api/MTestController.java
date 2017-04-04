package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dao.AdminLogMapper;
import com.wuliangit.shopos.entity.AdminLog;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by nilme on 2017/3/21.
 */

@RestController
@RequestMapping("/api/v1/test")
public class MTestController {


    @RequestMapping("/api")
    public Object api1(Integer a)  {
        RestResult result = new RestResult();

        System.out.println(a);

        return result;
    }

    @RequestMapping("/api2")
    public Object api2(Integer a)  {
        RestResult result = new RestResult();


        return result;
    }

}
