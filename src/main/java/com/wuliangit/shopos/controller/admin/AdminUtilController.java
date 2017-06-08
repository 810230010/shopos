package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nilme on 2017/3/21.
 */

@RestController
@RequestMapping("/admin/util")
public class AdminUtilController {


    /**
     * 获取七牛上传图片接口
     *
     * @return
     */
    @RequestMapping(value = "/qiniu/uptoken")
    @ResponseBody
    public Object getUpToken() {
        RestResult result = new RestResult();
        result.add("uptoken", QiNiuUtils.getToken());
        return result;
    }

    @RequestMapping(value = "/donothing")
    @ResponseBody
    public Object donothing() {
        RestResult result = new RestResult();
        return result;
    }

}
