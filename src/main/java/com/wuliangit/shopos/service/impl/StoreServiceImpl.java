package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.StoreJoininMapper;
import com.wuliangit.shopos.dao.StoreMapper;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.model.StoreBrand;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.StoreService;
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

    @Override
    public int createStoreJoinin(StoreJoinin storeJoinin) {
        return storeJoininMapper.insertSelective(storeJoinin);
    }

    @Override
    public StoreUser getStoreUser(Integer memberId) {
        return storeMapper.getStoreUser(memberId);
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

        StoreUser currentStore = WebUtil.getCurrentStore();
        StoreUser storeUser = storeMapper.getStoreUser(currentStore.getMemberId());

        SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_STORE,storeUser);
        return res;
    }

    @Override
    public List<StoreBrand> getStoreBrands(Integer page, Integer pageSize, String searchKey, Integer storeId) {
        PageHelper.startPage(page, pageSize);
        return storeMapper.getStoreBrands(storeId, searchKey);
    }
}
