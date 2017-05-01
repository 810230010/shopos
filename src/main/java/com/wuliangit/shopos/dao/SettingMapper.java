package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Setting;
import org.apache.ibatis.annotations.Param;

public interface SettingMapper extends BaseMapper<Setting, Integer> {

    /**
     * 更新设置表里的具体某项值
     * @param key
     * @param value
     * @return
     */
    Integer updateMail(@Param("key") String key,@Param("value") String value);

    /**
     * 得到设置表里的具体某项值
     * @param key
     * @return
     */
    String getSetting(String key);

}