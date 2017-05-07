package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.dto.StoreUpdateDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.GoodsAdService;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.shiro.SecurityUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/4/28.
 */

@Controller
@RequestMapping("/store/setting")
public class StoreSettingController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private Mapper mapper;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsAdService goodsAdService;

    /**
     * 店铺信息修改页面
     * @param model
     * @return
     */
    @RequestMapping("")
    public String indexPage(Model model){
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.BASE_URL);

        StoreUser currentStore = WebUtil.getCurrentStore();
        Store store = storeService.getStoreByStoreId(currentStore.getStoreId());
        model.addAttribute("store",store);
        return "/store/setting/index";
    }

    /**
     * 店铺信息修改
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Object setting(StoreUpdateDTO storeDto){
        RestResult result = new RestResult();
        Store store  = mapper.map(storeDto, Store.class);
        int res = storeService.updateStore(store);
        return result;
    }

    /**
     * 获取商品广告设置的展示界面
     * @param model
     * @return
     */
    @RequestMapping("/showAdPage")
    public String showAdPage(Model model){
       return "/store/setting/showadpage";
    }

    /**
     * 获取修改商品广告的修改界面
     * @param model
     * @param goodsId
     * @return
     */
    @RequestMapping("/updateAdPage")
    public String updateAdPage(Model model,Integer goodsId){
        StoreUser storeUser = (StoreUser) SecurityUtils.getSubject().getSession().getAttribute("SESSION_CURRENT_STORE");
        StoreGoodsDetailDTO result = goodsService.getSimplGoodsInfo(goodsId);
        String img = "";
        img = goodsAdService.getGoodsAdImg(goodsId,storeUser.getStoreId());
        result.setImg(img);
        model.addAttribute("goods",result);
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.BASE_URL);
        return "/store/setting/updateadpage";
    }

    /**
     * 获取修改商品广告的添加广告页面
     * @param model
     * @return
     */
    @RequestMapping("/addadpage")
    public String addadpage(Model model){
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.BASE_URL);
        return "/store/setting/addadpage";
    }

}
