package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nilme on 2017/5/27.
 */

@Controller
@RequestMapping(value = "/api/v1/seller")
public class MsellerController {

    @RequestMapping("/goods/add")
    public Object GoodsAdd(){
        RestResult result = new RestResult();




        return result;
    }

}
