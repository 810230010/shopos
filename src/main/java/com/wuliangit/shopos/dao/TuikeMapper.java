package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.TuikeMemberDTO;
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
    List<TuikeMemberDTO> getCheckList(@Param("searchKey") String searchKey, @Param("orderColumn") String orderColumn, @Param("orderType") String orderType);

}