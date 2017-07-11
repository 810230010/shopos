package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.Activity;
import com.wuliangit.shopos.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/11.
 */
@RestController
@RequestMapping("/api/v1/public/activity")
public class MActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 获取活动列表数据
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/getActivityList")
    private Object getActivityList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        RestResult result = new RestResult();
        List<Activity> data = activityService.getActivityList(page,pageSize,"activity_sort","desc",null);
        result.add("data",data);
        return result;
    }

}
