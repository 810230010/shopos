package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.LoadingPicDTO;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/1.
 */
public interface LoadingAdService {
    /**
     * 获取载进广告数据
     * @return
     */
    List<LoadingPicDTO> getLoadingAdListDate();

    /**
     * 获取载进广告条数
     * @return
     */
    Integer getLoadingAdNumber();

    /**
     * 添加载进图片
     * @param img
     * @return
     */
    Integer addLoadingPic(String img);

    /**
     * 删除载进图
     * @param id
     * @return
     */
    Integer deleteLoadingAd(Integer id);

    /**
     * 修改状态
     * @param id
     * @param open
     * @return
     */
    Integer modifyStatus(Integer id, Boolean open);

    /**
     * 获取启用载进图
     * @return
     */
    String getLoadingPic();
}
