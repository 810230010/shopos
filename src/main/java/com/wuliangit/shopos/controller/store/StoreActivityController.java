package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by JangJanPing on 2017/7/11.
 */
@Controller
@RequestMapping("/store/activity")
public class StoreActivityController {
     @Autowired
     private ActivityService activityService;
    /**
     * 商家添加商品时获得有效的活动
     * @return
     */
    @RequestMapping("/getValidActivities")
    @ResponseBody
    public Object getSimplifiedActivity(){
        RestResult result = new RestResult();
        result.add("activities", activityService.getAllValidActivities());
        return result;
    }
}
