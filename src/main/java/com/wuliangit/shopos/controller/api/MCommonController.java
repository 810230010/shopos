package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.Area;
import com.wuliangit.shopos.service.AreaService;
import com.wuliangit.shopos.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * 平台公共信息接口
 * Created by nilme on 2017/5/6.
 */


@RestController
@RequestMapping("/api/v1/public/common")
public class MCommonController {

    @Autowired
    private AreaService areaService;
    @Autowired
    private SettingService settingService;


    /**
     * 获取地址选择列表
     * @param parentId
     * @return
     */
    @RequestMapping("/area")
    public Object getArea(@RequestParam(defaultValue = "0") Integer parentId){
        RestResult result = new RestResult();
        List<Area> areas = areaService.getArea(parentId);
        result.add("areas",areas);
        return result;
    }

    /**
     * app得到注册公约
     * @return
     */
    @RequestMapping("/regulation/registery")
    @ResponseBody
    public Object getRegisteryRegulation(){
        RestResult result = new RestResult();
        result.add("registeryRegulation", settingService.getRegisterRegulation());
        return result;
    }
    /**
     * app得到成为商家公约
     * @return
     */
    @RequestMapping("/regulation/beStore")
    @ResponseBody
    public Object getBeStoreRegulation(){
        RestResult result = new RestResult();
        result.add("beStoreRegulation", settingService.getBeStoreRegulation());
        return result;
    }


}
