package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.TuikeCheckListDTO;
import com.wuliangit.shopos.dto.TuikePageListDTO;
import com.wuliangit.shopos.entity.Tuike;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TuikeMapper extends BaseMapper<Tuike, Integer> {

    /**
     * 是否审核通过操作
     * @param memberId
     * @param state
     * @return
     */
    Integer checkOperation(@Param("memberId")Integer memberId,@Param("state") String state);

    /**
     * 获取推客审核列表
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<TuikeCheckListDTO> getCheckList(@Param("searchKey") String searchKey, @Param("orderColumn") String orderColumn, @Param("orderType") String orderType);

    /**
     * 获取推客管理列表
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<TuikePageListDTO> getTuikeList(@Param("searchKey") String searchKey, @Param("orderColumn") String orderColumn, @Param("orderType") String orderType);

    /**
     * 禁用推客
     * @param tuikeId
     * @param state
     * @return
     */
    Integer forbiddenTuike(@Param("tuikeId") Integer tuikeId,@Param("state") String state);

}