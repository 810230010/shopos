package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.BannerDTO;
import com.wuliangit.shopos.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper extends BaseMapper<Banner , Integer> {

    /**
     * @Description: 获取banner列表数据
     * @Author: pangweichao
     * @Date: 15:01 2017/6/2
     * @Param: [searchKey, orderColumn, orderType]
     * @return: java.util.List<com.wuliangit.shopos.entity.Banner>
     */
    List<BannerDTO> getBannerListDate(@Param("searchKey") String searchKey,
                                      @Param("orderColumn") String orderColumn,
                                      @Param("orderType") String orderType);

    /**
     * @Description: 更改状态
     * @Author: pangweichao
     * @Date: 16:01 2017/6/2
     * @Param: [tBannerId, statusFlag]
     * @return: java.lang.Object
     */
    Integer modifyStatus(@Param("tBannerId") Integer tBannerId,
                         @Param("statusFlag") Integer statusFlag);

    /**
     * @Description: 获取已启用的banner图
     * @Author: pangweichao
     * @Date: 16:25 2017/6/2
     * @Param: []
     * @return: java.util.List<com.wuliangit.shopos.dto.BannerDTO>
     */
    List<BannerDTO> getBannerListWithOpen();

}