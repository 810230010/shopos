package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.MemberAdvice;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface MemberAdviceMapper extends BaseMapper<MemberAdvice, Integer>{
    /**
     * 查询会员留言列表
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    ArrayList<MemberAdvice> queryMemberAdviceList(@Param("orderColumn") String orderColumn,
                                                  @Param("orderType") String orderType,
                                                  @Param("searchKey") String searchKey);

    /**
     * 更改留言浏览状态
     * @param adviceId
     * @return
     */
    int updateAdviceLookStatus(@Param("adviceId") Integer adviceId);
}