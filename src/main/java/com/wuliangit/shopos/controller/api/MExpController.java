package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.exp.ExpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 快递查询接口
 * Created by nilme on 2017/5/17.
 */

@RestController
@RequestMapping(value = "/api/v1/exp")
public class MExpController {

    /**
     * 快递查询接口
     * @param com
     * @param nu
     * @return
     */
    @RequestMapping(value = "expInfo")
    public String expInfo(String com, String nu) {
        String s = ExpUtil.doQuery(com, nu);
        return s;
    }
}
