package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Tuike;
import org.apache.ibatis.annotations.Param;

public interface TuikeMapper extends BaseMapper<Tuike, Integer> {

<<<<<<< HEAD
=======
    /**
     * 是否审核通过操作
     * @param memberId
     * @param state
     * @return
     */
    Integer checkOperation(@Param("memberId")Integer memberId,@Param("state") String state);

>>>>>>> 93eb8a0e10a9d3ab82633a27890286d54420fd60
}