package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.dao.StoreJoininMapper;
import com.wuliangit.shopos.dao.StoreMapper;
import com.wuliangit.shopos.dto.ApiStoreListDTO;
import com.wuliangit.shopos.dto.StoreDetailDTO;
import com.wuliangit.shopos.dto.StorePageListDTO;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nilme on 2017/3/27.
 */

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreJoininMapper storeJoininMapper;

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private GoodsService goodsService;

    @Override
    public int createStoreJoinin(StoreJoinin storeJoinin) {
        return storeJoininMapper.insertSelective(storeJoinin);
    }

    @Override
    public Set<String> getRoles(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("store");
        return roles;
    }

    @Override
    public Set<String> getPermissions(String username) {
        return null;
    }

    @Override
    public Store getStoreByStoreId(Integer storeId) {
        return storeMapper.selectByPrimaryKey(storeId);
    }

    @Override
    public int updateStore(Store store) {
        int res = storeMapper.updateByPrimaryKeySelective(store);
        StoreMin storeMin = storeMapper.getStoreMinByStoreId(store.getStoreId());
        SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_STORE, storeMin);
        return res;
    }

    @Override
    public List<StorePageListDTO> getStoreList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        PageHelper.startPage(page, pageSize);
        List<StorePageListDTO> result = storeMapper.getStoreList(orderColumn, orderType, searchKey);
        return result;
    }

    @Override
    public Integer updateStoreState(Integer storeId, String state) {
        return storeMapper.updateStoreState(storeId, state);
    }

    @Override
    public StoreDetailDTO getStoreDetailInfo(Integer storeId) {
        return storeMapper.getStoreDetailInfo(storeId);
    }

    @Override
    public StoreMin getStoreMinByStoreId(Integer storeId) {
        return storeMapper.getStoreMinByStoreId(storeId);
    }

    @Override
    public List<ApiStoreListDTO> apiStoreSearch(Integer page, Integer pageSize, String searchKey, String order, String type) {
        PageHelper.startPage(page, pageSize);

        if (!StringUtils.isEmpty(order)) {
            order = order.toLowerCase();
        }

        List<ApiStoreListDTO> stores = storeMapper.apiStoreSearch(searchKey, order, type);
        for (ApiStoreListDTO store : stores) {
            store.setGoodsCount(goodsService.getGoodsCountByStoreId(store.getStoreId()));
        }
        return stores;
    }
}
