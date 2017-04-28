package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.StoreUpdateDTO;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.StoreService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 店铺信息修改页面
     * @param model
     * @return
     */
    @RequestMapping("")
    public String indexPage(Model model){
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.BASE_URL);

        StoreMin currentStore = WebUtil.getCurrentStore();
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
}
