package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Setting;
import org.apache.ibatis.annotations.Param;

public interface SettingMapper extends BaseMapper<Setting, Integer> {

    /**
     * 得到设置表里的具体某项值
     * @param key
     * @return
     */
    String getSetting(String key);


    /**
     * 更新设置表里的具体某项值
     * @param mailServiceSite
     * @param mailServiceSite1
     * @return
     */
    Integer updateSetting(@Param("key")String mailServiceSite, @Param("value") String mailServiceSite1);
}