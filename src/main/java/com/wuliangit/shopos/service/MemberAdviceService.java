package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.MemberAdvice;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/5/14.
 */
public interface MemberAdviceService {

    /**
     * 查询会员留言列表
     * @param page
     * @param pageSize
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    ArrayList<MemberAdvice> getMemberAdviceList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey);

    /**
     * 更改留言查看状态
     * @param adviceId
     * @return
     */
    int updateAdviceLookStatus(Integer adviceId);

    /**
     * 删除留言
     * @param adviceId
     * @return
     */
    int deleteAdvice(Integer adviceId);
}
