package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.StoreJoinin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface StoreJoininMapper extends BaseMapper<StoreJoinin, Integer> {
     /**
      * 根据条件搜索
      * @param searchKey
      * @return
      */
     ArrayList<StoreJoinin> queryJoinStores(@Param("searchKey") String searchKey);

     /**
      * 审核不通过
      * @param joininMessage
      * @return
      */
     int rejectStoreJoininApply(@Param("joininMessage") String joininMessage, @Param("memberId") Integer memberId);

     int passStoreJoininApply(@Param("memberId") Integer memberId);
}