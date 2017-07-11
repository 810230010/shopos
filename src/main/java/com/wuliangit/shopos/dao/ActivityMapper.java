package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.SimpleActivityDTO;
import com.wuliangit.shopos.entity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/10.
 */
public interface ActivityMapper extends BaseMapper<Activity , Integer> {

    /**
     * 获取活动列表数据
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<Activity> getActivityList(@Param("orderColumn") String orderColumn,
                                   @Param("orderType") String orderType,
                                   @Param("searchKey") String searchKey);

    /**
     * 更改活动状态
     * @param activityId
     * @param activityState
     * @return
     */
    Integer updateActivityState(@Param("activityId") Integer activityId,
                                @Param("activityState") Boolean activityState);

    /**
     * 查询所有有效的活动
     * @return
     */
    List<SimpleActivityDTO> getAllValidActivities();
}
