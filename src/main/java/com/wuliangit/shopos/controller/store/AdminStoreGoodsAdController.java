package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.StoreGoodsDetailDTO;
import com.wuliangit.shopos.entity.StoreGoodsAd;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.StoreGoodsAdService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2017/5/8.
 */
@Controller
@RequestMapping("/store/goods")
public class AdminStoreGoodsAdController {

    @Autowired
    private StoreGoodsAdService storeGoodsAdService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 更新商品广告
     * @param storeGoodsAd
     * @return
     * @throws Exception
     */
    @RequestMapping("updateGoodsAd")
    @ResponseBody
    public Object updateGoodsAd(StoreGoodsAd storeGoodsAd) throws Exception{
        RestResult result = new RestResult();
        storeGoodsAdService.updateGoodsAd(storeGoodsAd);
        return result;
    }

    /**
     * 获取商铺商品信息
     * @return
     */
    @RequestMapping("/getStoreGoods")
    @ResponseBody
    public Object getStoreGoods(){
        RestResult result = new RestResult();
        StoreUser storeUser = (StoreUser) SecurityUtils.getSubject().getSession().getAttribute("SESSION_CURRENT_STORE");
        Integer storeId = storeUser.getStoreId();
        List<StoreGoodsDetailDTO> info = goodsService.getStoreGoods(storeId);
        List<StoreGoodsDetailDTO> fina = new ArrayList<StoreGoodsDetailDTO>();
        for(StoreGoodsDetailDTO storeGoodsDetailDTO : info){
            String img = "";
            img = storeGoodsAdService.getGoodsAdImg(storeGoodsDetailDTO.getGoodsId(),storeId);
            storeGoodsDetailDTO.setImg(img);
            fina.add(storeGoodsDetailDTO);
        }
        result.put("data",fina);
        return result;
    }

    /**
     * 插入商品广告
     * @param storeGoodsAd
     * @return
     */
    @RequestMapping("/insertGoodsAd")
    @ResponseBody
    public Object insertGoodsAd(StoreGoodsAd storeGoodsAd) throws Exception{
        RestResult result = new RestResult();
        StoreUser storeUser = (StoreUser) SecurityUtils.getSubject().getSession().getAttribute("SESSION_CURRENT_STORE");
        Integer info = storeGoodsAdService.insertGoodsAd(storeGoodsAd);
        return result;
    }

    /**
     * 验证商品是否有图片
     * @param goodsId
     * @return
     */
    @RequestMapping("/verifyImg")
    @ResponseBody
    public Object verifyImg(Integer goodsId){
        RestResult result = new RestResult();
        StoreUser storeUser = (StoreUser) SecurityUtils.getSubject().getSession().getAttribute("SESSION_CURRENT_STORE");
        String info = storeGoodsAdService.getGoodsAdImg(goodsId,storeUser.getStoreId());
        result.put("data",info);
        return result;
    }

}
