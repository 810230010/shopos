package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.GoodsSkuMapper;
import com.wuliangit.shopos.entity.GoodsSku;
import com.wuliangit.shopos.service.GoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nilme on 2017/4/27.
 */
@Service
public class GoodsSkuServiceImpl implements GoodsSkuService {

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;

    @Override
    public List<GoodsSku> getGoodsSkuByGoodsId(Integer goodsId) {
        return goodsSkuMapper.getGoodsSkuByGoodsId(goodsId);
    }

    @Override
    @Transactional
    public int updateSku(List<GoodsSku> skus) {
        int successNum = 0;
        for (GoodsSku sku : skus) {
            goodsSkuMapper.updateByPrimaryKeySelective(sku);
            successNum++;
        }
        return successNum;
    }
}
