package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.dao.GoodsAdMapper;
import com.wuliangit.shopos.entity.GoodsAd;
import com.wuliangit.shopos.exception.BaseException;
import com.wuliangit.shopos.service.GoodsAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 26229 on 2017/5/6.
 */
@Service
public class GoodsAdServiceImpl implements GoodsAdService {

    @Autowired
    private GoodsAdMapper goodsAdMapper;

    @Override
    public String getGoodsAdImg(Integer goodsId, Integer storeId) {
        return goodsAdMapper.getGoodsAdImg(goodsId,storeId);
    }

    @Override
    public Integer updateGoodsAd(Integer goodsId, Integer storeId, String img) throws Exception {
        Integer result = goodsAdMapper.updateGoodsAd(goodsId,storeId,img);
        if(result != 1){
            throw new BaseException("设置失败");
        }
        return result;
    }

    @Override
    public Integer insertGoodsAd(Integer storeId, Integer goodsId, String img) throws Exception {
        GoodsAd goods = new GoodsAd(goodsId,storeId,img);
        Integer info = goodsAdMapper.insert(goods);
        if(info != 1){
            throw new BaseException("插入失败");
        }
        return info;
    }
}
