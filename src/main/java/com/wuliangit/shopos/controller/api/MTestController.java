package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.model.OrderGoodsInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nilme on 2017/3/21.
 */

@RestController
@RequestMapping("/api/v1/test")
public class MTestController {

    private static Log logger = LogFactory.getLog(MTestController.class);
    

    @RequestMapping("/api")
    public Object api1(@RequestParam(required = true) Integer a) throws Exception {
        RestResult result = new RestResult();

        if (true) {
            throw new Exception("Exception");
        }

        return result;
    }

    @RequestMapping("/p")
    public Object api2(OrderGoodsInfo orderGoodsNum1, Integer storeId) {
        RestResult result = new RestResult();


        return result;
    }

    @RequestMapping("/p2")
    public Object api3(@RequestParam("orderIds[]") List<Integer> orderIds) {
        RestResult result = new RestResult();


        return result;
    }

}
