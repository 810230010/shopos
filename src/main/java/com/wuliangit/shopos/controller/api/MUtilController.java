package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nilme on 2017/3/21.
 */

@RestController
@RequestMapping("/api/v1/util")
public class MUtilController {


    /**
     * 获取七牛上传图片接口
     * @return
     */
    @RequestMapping(value = "/qiniu/uptoken")
    public @ResponseBody
    Object getUpToken(){
        RestResult result = new RestResult();
        result.put("uptoken", QiNiuUtils.getToken());
        return result;
    }

}
