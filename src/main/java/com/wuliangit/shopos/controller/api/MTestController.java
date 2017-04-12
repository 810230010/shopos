package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequiresPermissions("admin")
    public Object api2(Integer a)  {
        RestResult result = new RestResult();

        return result;
    }

}
