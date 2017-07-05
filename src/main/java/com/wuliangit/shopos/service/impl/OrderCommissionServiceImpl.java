package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.OrderCommissionMapper;
import com.wuliangit.shopos.dto.TuikeOrderListDTO;
import com.wuliangit.shopos.service.OrderCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuliang01 on 2017/7/5.
 */
@Service
public class OrderCommissionServiceImpl implements OrderCommissionService {

    @Autowired
    private OrderCommissionMapper orderCommissionMapper;

    @Override
    public List<TuikeOrderListDTO> getTuikeOrderList(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return orderCommissionMapper.getTuikeOrderList(searchKey,orderColumn,orderType);
    }
}
