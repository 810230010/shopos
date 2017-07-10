package com.wuliangit.shopos.controller.api;

import com.alipay.api.AlipayApiException;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.api.ApiGoodsListDTO;
import com.wuliangit.shopos.dto.api.ApiSellerInfo;
import com.wuliangit.shopos.dto.api.ApiStoreJoininDTO;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.entity.StoreAccount;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.StoreAccountService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by nilme on 2017/5/27.
 */

@RestController
@RequestMapping(value = "/api/v1/seller")
public class MSellerController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreAccountService storeAccountService;

    /**
     * 添加商品
     *
     * @param goodsCategory1Id 一级分类
     * @param goodsCategory2Id 二级分类
     * @param goodsCategory3Id 三级分类
     * @param name             商品名称
     * @param price            价格
     * @param carriage         邮费
     * @param storage          库存
     * @param type             商品类型 GOODS_TYPE_NORMAL(普通商品)；GOODS_TYPE_SECKILL(一口秒价); GOODS_TYPE_ACTIVITY(企业活动商品);
     *                         GOODS_TYPE_NEWGOODS(企业新品商品); GOODS_TYPE_DIRECTSELLING(企业直销商品)
     * @param unit             单位
     * @param goodsBody        商品描述
     * @return
     */
    @RequestMapping(value = "/goods/add", method = RequestMethod.POST)
    public Object GoodsAdd(Integer goodsCategory1Id,
                           Integer goodsCategory2Id,
                           Integer goodsCategory3Id,
                           String name,
                           BigDecimal price,
                           BigDecimal carriage,
                           Integer storage,
                           String type,
                           String unit,
                           String goodsBody,
                           String images,
                           Double gpsLng,
                           Double gpsLat) {
        RestResult result = new RestResult();
        int res = goodsService.apiCreateGooods(goodsCategory1Id, goodsCategory2Id, goodsCategory3Id,
                name, price, carriage, storage, type, unit, goodsBody, images, gpsLng, gpsLat);
        return result;
    }

    /**
     * 更新商品
     *
     * @param goodsCategory1Id
     * @param goodsCategory2Id
     * @param goodsCategory3Id
     * @param name
     * @param price
     * @param carriage
     * @param storage
     * @param type
     * @param unit
     * @param goodsBody
     * @param images
     * @return
     */
    @RequestMapping(value = "/goods/update", method = RequestMethod.POST)
    public Object updateGoods(Integer goodsId,
                              Integer goodsCategory1Id,
                              Integer goodsCategory2Id,
                              Integer goodsCategory3Id,
                              String name,
                              BigDecimal price,
                              BigDecimal carriage,
                              Integer storage,
                              String type,
                              String unit,
                              String goodsBody,
                              String images) {
        RestResult result = new RestResult();
        int res = goodsService.apiUpdateGoods(goodsId, goodsCategory1Id, goodsCategory2Id, goodsCategory3Id,
                name, price, carriage, storage, type, unit, goodsBody, images);
        return result;
    }

    /**
     * 获取店铺移动端可以编辑的商品
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/goods/canEdit")
    public Object getGoodsCanEdit(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods = goodsService.sellerGetGoodsCanEdit(page, pageSize);

        for (ApiGoodsListDTO good : goods) {
            good.setTitleImg(QiNiuUtils.resizeImge(good.getTitleImg()));
        }

        result.add("goods", goods);
        return result;
    }

    /**
     * 商家信息
     */
    @RequestMapping("/info")
    public Object sellerInfo() {
        RestResult result = new RestResult();
        ApiSellerInfo apiSellerInfo = storeService.getSellerInfo();


        return result;
    }


    /**
     * 申请成为商家
     *
     * @return
     */
    @RequestMapping("/newStore")
    public Object applyStore(ApiStoreJoininDTO apiStoreJoininDTO) throws OptionException {
        RestResult result = new RestResult();
        int res = storeService.createStoreJoinin(apiStoreJoininDTO);
        return result;
    }


    /**
     * 店铺支付宝提现
     *
     * @param amount
     * @return
     * @throws OptionException
     */
    @RequestMapping(value = "/cash", method = RequestMethod.POST)
    public Object doCash(BigDecimal amount) throws OptionException, AlipayApiException {
        RestResult result = new RestResult();
        int res = storeAccountService.apisStoreDoCash(amount);
        return result;
    }


    /**
     * 修改或设置提现支付宝账户
     *
     * @return
     */
    @RequestMapping(value = "/settingAlipay", method = RequestMethod.POST)
    public Object settingAlipay(String alipayAccount) {
        RestResult result = new RestResult();
        int res = storeAccountService.apiSettingStoreAlipay(alipayAccount);
        return result;
    }

    /**
     * 获取现有提现支付宝账户
     *
     * @return
     */
    @RequestMapping(value = "/getStoreAccount", method = RequestMethod.POST)
    public Object getStoreAccount() throws OptionException {
        RestResult result = new RestResult();
        StoreAccount storeAccount = storeAccountService.apiGetAlipayCashAccount();
        result.add("AlipayCashAccount", storeAccount);
        return result;
    }

    /**
     * 更新店铺信息
     *
     * @return
     */
    @RequestMapping(value = "/updateStore", method = RequestMethod.POST)
    public Object updateStore(String logo, String name, String phone) {
        RestResult result = new RestResult();

        Store store = WebUtil.mobileGetCurrentStore();

        if (!StringUtils.isEmpty(logo)){
            store.setLogo(QiNiuUtils.getBaseUrl() + logo);
        }
        if (!StringUtils.isEmpty(name)){
            store.setName(name);
        }
        if (!StringUtils.isEmpty(phone)){
            store.setPhone(phone);
        }
        storeService.updateStore(store);
        return result;
    }

    

}
