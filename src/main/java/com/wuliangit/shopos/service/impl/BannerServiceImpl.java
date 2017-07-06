package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.dao.BannerMapper;
import com.wuliangit.shopos.dto.BannerDTO;
import com.wuliangit.shopos.entity.Banner;
import com.wuliangit.shopos.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<BannerDTO> getBannerListDate(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<BannerDTO> banners = bannerMapper.getBannerListDate(searchKey,orderColumn,orderType);
        return banners;
    }

    @Override
    public Integer addBanner(String img) {
        Banner banner = new Banner();
        banner.setPictureUrl(img);
        banner.setStatusFlag(true);
        return bannerMapper.insert(banner);
    }

    @Override
    public Integer deleteBanner(Integer tBannerId) {
        return bannerMapper.deleteByPrimaryKey(tBannerId);
    }

    @Override
    public Integer changeStatus(Integer tBannerId, String statusFlag) {
        Integer result = 0;
        if(statusFlag.equals("false")){
            result = bannerMapper.modifyStatus(tBannerId,1);
        }else{
            result = bannerMapper.modifyStatus(tBannerId,0);
        }
        return result;
    }

    @Override
    public List<BannerDTO> getBannerListWithOpen() {
        return bannerMapper.getBannerListWithOpen();
    }
}
