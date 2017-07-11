package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dao.ActivityMapper;
import com.wuliangit.shopos.entity.Activity;
import com.wuliangit.shopos.entity.AdminLog;
import com.wuliangit.shopos.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wuliang01 on 2017/7/10.
 */
@Controller
@RequestMapping("/admin/activity")
public class AdminActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/activityListPage")
    public String activityListPage(Model model){
        return "admin/activity/activity_list";
    }

    @RequestMapping("/addActivityPage")
    public String addActivityPage(Model model){
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        return "admin/activity/add_activity";
    }

    @RequestMapping("/checkActivityGoodsList")
    public String checkActivityGoodsList(Model model){
        return "admin/activity/activity_goods_check";
    }

    /**
     * 获取活动列表数据
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/getActivityList")
    @ResponseBody
    public Object getActivityList(@RequestParam("draw") int draw,
                                  @RequestParam(value = "searchKey", required = false) String searchKey,
                                  @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                  @RequestParam(value = "orderType", required = false) String orderType,
                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<Activity> info = activityService.getActivityList(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult<Activity>(info,draw);
    }

    /**
     * 更改活动状态
     * @param activityId
     * @param activityState
     * @return
     */
    @RequestMapping("/updateActivityState")
    @ResponseBody
    private Object updateActivityState(Integer activityId,Boolean activityState){
        RestResult result = new RestResult();
        Integer updateNum = activityService.updateActivityState(activityId,activityState);
        if(updateNum != 1){
            result.add("code",RestResult.CODE_SERVERERROR);
        }
        return result;
    }

    /**
     * 添加活动
     * @param name
     * @param img
     * @param desc
     * @param sort
     * @param datetimeStart
     * @param datetimeEnd
     * @return
     */
    @RequestMapping("/addActivity")
    @ResponseBody
    public Object addActivity(String name, String img, String desc, String sort, String datetimeStart,String datetimeEnd,String state) throws ParseException {
        RestResult result = new RestResult();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Activity activity = new Activity();
        activity.setActivityBanner(img);
        activity.setActivityType("todo");
        activity.setActivityDesc(desc);
        activity.setActivitySort(sort);
        activity.setActivityTitle(name);
        activity.setActivityEndTime(sdf.parse(datetimeEnd));
        activity.setActivityStartTime(sdf.parse(datetimeStart));
        activity.setActivityState(Boolean.valueOf(state));
        Integer updateNum = activityService.addActivity(activity);
        if(updateNum != 1){
            result.add("code",RestResult.CODE_SERVERERROR);
        }
        return result;
    }

}
