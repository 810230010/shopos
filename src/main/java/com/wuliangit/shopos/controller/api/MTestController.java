package com.wuliangit.shopos.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nilme on 2017/3/21.
 */


@RestController
@RequestMapping("/test")
public class MTestController {

    @RequestMapping("/exception")
    public Object login() throws Exception {
        throw new Exception("测试错误");
    }
}
