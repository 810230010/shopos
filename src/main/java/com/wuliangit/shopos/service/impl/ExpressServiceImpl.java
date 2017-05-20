package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.ExpressMapper;
import com.wuliangit.shopos.entity.Express;
import com.wuliangit.shopos.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nilme on 2017/5/19.
 */

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private ExpressMapper expressMapper;

    @Override
    public List<Express> getExpressList(String searchKey) {
        return expressMapper.getExpressList(searchKey);
    }
}
