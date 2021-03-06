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
     * @param key
     * @param value
     * @return
     */
    Integer updateSetting(@Param("key")String key, @Param("value") String value);

    /**
     * 得到注册公约
     * @return
     */
    String getRegisterRegulation();

    /**
     * 修改注册公约
     * @param regulationContent
     * @return
     */
    int updateRegisteryRegulation(@Param("regulationContent")String regulationContent);

    /**
     * 得到成为商家条约
     * @return
     */
    String getBeStoreRegulation();

    /**
     * 修改成为商家条约
     * @param regulationContent
     * @return
     */
    int updateBeStoreRegulation(@Param("regulationContent") String regulationContent);
}