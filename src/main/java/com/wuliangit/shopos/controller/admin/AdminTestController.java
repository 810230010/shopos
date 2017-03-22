package com.wuliangit.shopos.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nilme on 2017/3/21.
 */


@Controller
@RequestMapping("/admin/test")
public class AdminTestController {

    @RequestMapping("/exception")
    public String login(Integer a) throws Exception {
        if (a==null){
            throw new Exception("测试错误");
        }
       return "admin/login";
    }
}
