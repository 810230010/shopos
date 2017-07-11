package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.SimpleActivityDTO;
import com.wuliangit.shopos.entity.Activity;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/10.
 */
public interface ActivityService {

    /**
     * 获取活动列表数据
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    List<Activity> getActivityList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey);

    /**
     * 更改活动状态
     * @param activityId
     * @param activityState
     * @return
     */
    Integer updateActivityState(Integer activityId, Boolean activityState);

    /**
     * 添加活动
     * @param activity
     * @return
     */
    Integer addActivity(Activity activity);

    /**
     * 商家添加商品得到所有有效的活动
     * @return
     */
    List<SimpleActivityDTO> getAllValidActivities();
}
