package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.api.ApiTuikeShareDTO;
import com.wuliangit.shopos.dto.api.ApiTuikeShareDataDTO;
import com.wuliangit.shopos.entity.TuikeShare;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nilme on 2017/7/5.
 */
public interface TuikeShareMapper extends BaseMapper<TuikeShare, Integer>{
    /**
     * 获取成功分享的数据
     * @param tuikeId
     * @return
     */
    List<ApiTuikeShareDataDTO> getShareInfo(@Param("tuikeId") Integer tuikeId);
}
