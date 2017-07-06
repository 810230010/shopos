package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.StoreJoininMapper;
import com.wuliangit.shopos.dao.StoreMapper;
import com.wuliangit.shopos.dao.StoreMessageMapper;
import com.wuliangit.shopos.dto.*;
import com.wuliangit.shopos.dto.api.ApiSellerInfo;
import com.wuliangit.shopos.dto.api.ApiStoreDTO;
import com.wuliangit.shopos.dto.api.ApiStoreJoininDTO;
import com.wuliangit.shopos.dto.api.ApiStoreListDTO;
import com.wuliangit.shopos.entity.*;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    private CollectService collectService;
    @Autowired
    private StoreGoodsAdService storeGoodsAdService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private Mapper mapper;
    @Autowired
    private StoreMessageMapper storeMessageMapper;


    @Override
    public int createStoreJoinin(ApiStoreJoininDTO apiStoreJoininDTO) throws OptionException {
        Member member = WebUtil.getCurrentMember();

        StoreJoinin storeJoinin = mapper.map(apiStoreJoininDTO, StoreJoinin.class);

        storeJoinin.setMemberId(member.getMemberId());
        storeJoinin.setMemberName(member.getUsername());
        storeJoinin.setCreateTime(new Date());

        StoreJoinin storeJoinin1 = storeJoininMapper.getByMemberId(member.getMemberId());

        if (storeJoinin1 != null) {
            throw new OptionException("您已经提交过申请");
        }

        Store store = storeMapper.getStoreByBindMemberUsername(member.getUsername());

        if (store != null) {
            throw new OptionException("您已经绑定过店铺");
        }

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
            store.setCollectCount(collectService.getStoreCollectCount(store.getStoreId()));
        }
        return stores;
    }

    @Override
    public ApiStoreDTO apiGetStoreDTO(Integer storeId) {
        ApiStoreDTO apiStore = storeMapper.getApiStoreDTOById(storeId);
        apiStore.setCollectCount(collectService.getStoreCollectCount(apiStore.getStoreId()));
        apiStore.setGoodsCount(goodsService.getGoodsCountByStoreId(apiStore.getStoreId()));
        apiStore.setGoodsAds(storeGoodsAdService.apiGetStoreGoodsAd(apiStore.getStoreId()));

        Area area = areaService.getById(apiStore.getProvinceId());

        if (area != null) {
            apiStore.setProvince(area.getName());
        }

        return apiStore;
    }

    @Override
    public int createStore(Store store) {
        store.setCreateTime(new Date());
        return storeMapper.insertSelective(store);
    }

    @Override
    public Store getStoreByBindMemberUsername(String phone) {
        return storeMapper.getStoreByBindMemberUsername(phone);
    }

    @Override
    public List<AdminMailToSelectDTO> getAllStore() {
        return storeMapper.getAllStore();
    }

    @Override
    public ApiSellerInfo getSellerInfo() {
        Member member = WebUtil.getCurrentMember();
        ApiSellerInfo apiSellerInfo = storeMapper.getSellerInfoBybindMemberUsername(member.getUsername());
        return apiSellerInfo;
    }

    @Override
    public Integer sendStoreMessage(String content, Integer storeId) {
        String name = storeMapper.getName(storeId);
        Admin admin = WebUtil.getCurrentAdmin();
        StoreMessage storeMessage = new StoreMessage();
        storeMessage.setContent(content);
        storeMessage.setCreateTime(new Date());
        storeMessage.setDelFlag(false);
        storeMessage.setTitle("违规警告");
        storeMessage.setReadFlag(false);
        storeMessage.setSendUserId(admin.getAdminId());
        storeMessage.setSendUserName(admin.getUsername());
        storeMessage.setReceiveUserId(storeId);
        storeMessage.setReceiveUserName(name);
        return storeMessageMapper.insert(storeMessage);
    }
}
