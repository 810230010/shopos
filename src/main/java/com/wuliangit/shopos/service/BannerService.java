package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.BannerDTO;
import com.wuliangit.shopos.entity.Banner;

import java.util.List;

/**
 * @author boom
 * @description Banner相关操作
 * @create 2017-06-02 14:56
 **/
public interface BannerService {

    /**
     * @Description: 获取banner列表数据
     * @Author: pangweichao
     * @Date: 15:01 2017/6/2
     * @Param: [searchKey, orderColumn, orderType, page, pageSize]
     * @return: java.util.List<com.wuliangit.shopos.entity.Banner>
     */
    List<BannerDTO> getBannerListDate(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize);

    /**
     * @Description: 添加banner图
     * @Author: pangweichao
     * @Date: 15:33 2017/6/2
     * @Param: [img]
     * @return: java.lang.Integer
     */
    Integer addBanner(String img);

    /**
     * @Description: 删除banner图
     * @Author: pangweichao
     * @Date: 15:52 2017/6/2
     * @Param: [tBannerId]
     * @return: java.lang.Integer
     */
    Integer deleteBanner(Integer tBannerId);

    /**
     * @Description: 更改状态
     * @Author: pangweichao
     * @Date: 16:01 2017/6/2
     * @Param: [tBannerId, statusFlag]
     * @return: java.lang.Object
     */
    Integer modifyStatus(Integer tBannerId,String statusFlag);

    /**
     * @Description: 获取已启用的banner图
     * @Author: pangweichao
     * @Date: 16:25 2017/6/2
     * @Param: []
     * @return: java.util.List<com.wuliangit.shopos.dto.BannerDTO>
     */
    List<BannerDTO> getBannerListWithOpen();

}
