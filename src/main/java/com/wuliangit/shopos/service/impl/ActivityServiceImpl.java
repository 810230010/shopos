package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.ActivityMapper;
import com.wuliangit.shopos.dto.SimpleActivityDTO;
import com.wuliangit.shopos.entity.Activity;
import com.wuliangit.shopos.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/10.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> getActivityList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        PageHelper.startPage(page,pageSize);
        List<Activity> result = activityMapper.getActivityList(orderColumn,orderType,searchKey);
        return result;
    }

    @Override
    public Integer updateActivityState(Integer activityId, Boolean activityState) {
        return activityMapper.updateActivityState(activityId,activityState);
    }

    @Override
    public Integer addActivity(Activity activity) {
        return activityMapper.insert(activity);
    }

    @Override
    public List<SimpleActivityDTO> getAllValidActivities() {
        return activityMapper.getAllValidActivities();
    }
}
