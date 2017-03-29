package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.EarningsDTO;

/**
 * Created by nilme on 2017/3/27.
 */
public interface TuikeService {

    /**
     * 获取推客收益
     * @return
     */
    EarningsDTO getEarnings();

    /**
     * 推客提现
     * @return
     */
    boolean earningsCash();
}
