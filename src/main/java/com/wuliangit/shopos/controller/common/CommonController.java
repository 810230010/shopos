package com.wuliangit.shopos.controller.common;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.Area;
import com.wuliangit.shopos.entity.Express;
import com.wuliangit.shopos.service.AreaService;
import com.wuliangit.shopos.service.ExpressService;
import com.wuliangit.shopos.service.LoadingAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nilme on 2017/4/28.
 */

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private ExpressService expressService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private LoadingAdService loadingAdService;

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

    /**
     * 获取快递公司信息
     * @return
     */
    @RequestMapping("/expressList")
    @ResponseBody
    public Object getExpressList(String searchkey){
        RestResult result = new RestResult();
        List<Express> expressList = expressService.getExpressList(searchkey);
        result.add("expressList",expressList);
        return result;
    }

    /**
     * 获取地址选择列表
     * @param parentId
     * @return
     */
    @RequestMapping("/area")
    @ResponseBody
    public Object getArea(@RequestParam(defaultValue = "0") Integer parentId){
        RestResult result = new RestResult();
        List<Area> areas = areaService.getArea(parentId);
        result.add("areas",areas);
        return result;
    }

    /**
     * 获取启用的载进图
     * @return
     */
    @RequestMapping("/getLoadingPic")
    @ResponseBody
    public Object getLoadingPic(){
        RestResult result = new RestResult();
        String img = loadingAdService.getLoadingPic();
        result.add("img",img);
        return result;
    }
}
