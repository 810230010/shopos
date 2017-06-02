package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.BannerDTO;
import com.wuliangit.shopos.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author boom
 * @description banner图相关接口
 * @create 2017-06-02 16:19
 **/
@RestController
@RequestMapping("/api/v1/public/banner")
public class MBannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * @Description: 获取启用的banner图
     * @Author: pangweichao
     * @Date: 16:23 2017/6/2
     * @Param: []
     * @return: java.lang.Object
     */
    @RequestMapping("/getBannerList")
    public Object getBannerList(){
        RestResult result = new RestResult();
        List<BannerDTO> info = bannerService.getBannerListWithOpen();
        result.add("data",info);
        return result;
    }

}
