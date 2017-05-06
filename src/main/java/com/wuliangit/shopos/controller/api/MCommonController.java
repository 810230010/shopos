package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.Area;
import com.wuliangit.shopos.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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


    /**
     * 获取地址选择列表
     * @param parentId
     * @return
     */
    @RequestMapping("/area")
    public Object getArea(Integer parentId){
        RestResult result = new RestResult();
        List<Area> areas = areaService.getArea(parentId);
        result.add("areas",areas);
        return result;
    }


}
