package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.StoreGoodsAdMapper;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.StoreGoodsAd;
import com.wuliangit.shopos.exception.BaseException;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.StoreGoodsAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 26229 on 2017/5/6.
 */
@Service
public class StoreGoodsAdServiceImpl implements StoreGoodsAdService {

    @Autowired
    private StoreGoodsAdMapper storeGoodsAdMapper;

    @Override
    public String getGoodsAdImg(Integer goodsId, Integer storeId) {
        return storeGoodsAdMapper.getStoreGoodsAdByStoreId(goodsId,storeId);
    }

    @Override
    public Integer updateGoodsAd(StoreGoodsAd storeGoodsAd) throws Exception {
        StoreUser currentStore = WebUtil.getCurrentStore();
        storeGoodsAd.setStoreId(currentStore.getStoreId());
        Integer result = storeGoodsAdMapper.updateGoodsAd(storeGoodsAd);
        if(result != 1){
            throw new BaseException("设置失败");
        }
        return result;
    }

    @Override
    public Integer insertGoodsAd(StoreGoodsAd storeGoodsAd) throws Exception {
        StoreUser currentStore = WebUtil.getCurrentStore();
        storeGoodsAd.setStoreId(currentStore.getStoreId());
        Integer info = storeGoodsAdMapper.insertSelective(storeGoodsAd);
        if(info != 1){
            throw new BaseException("插入失败");
        }
        return info;
    }

    @Override
    public List<StoreGoodsDetailDTO> getStoreGoodsWithAd(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize, Integer storeId) {
        PageHelper.startPage(page,pageSize);
        List<StoreGoodsDetailDTO> storeGoodsDetailDTOS = storeGoodsAdMapper.getStoreGoodsWithAd(searchKey,orderColumn,orderType,storeId);
        return storeGoodsDetailDTOS;
    }

    @Override
    public List<StoreGoodsDetailDTO> getStoreGoodsWithoutAd(Integer storeId) {
        return storeGoodsAdMapper.getStoreGoodsWithoutAd(storeId);
    }
}
