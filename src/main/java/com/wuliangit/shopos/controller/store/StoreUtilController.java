package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.RestResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nilme on 2017/4/28.
 */

@Controller
@RequestMapping("/store/util")
public class StoreUtilController {


    /**
     * 图片删除什么都不做
     * @return
     */
    @RequestMapping("/donothing")
    @ResponseBody
    public Object donothing(){
        RestResult result = new RestResult();
        return result;
    }

}
