package com.wuliangit.shopos.controller.api;

import com.alipay.api.AlipayApiException;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.ApiSellerInfo;
import com.wuliangit.shopos.entity.StoreAccount;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.GoodsService;
import com.wuliangit.shopos.service.StoreAccountService;
import com.wuliangit.shopos.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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
     *
     * @param goodsCategory1Id 一级分类
     * @param goodsCategory2Id 二级分类
     * @param goodsCategory3Id 三级分类
     * @param name 商品名称
     * @param price 价格
     * @param carriage 邮费
     * @param storage 库存
     * @param type 商品类型 GOODS_TYPE_NORMAL(普通商品)；GOODS_TYPE_SECKILL(一口秒价); GOODS_TYPE_ACTIVITY(企业活动商品);
     *             GOODS_TYPE_NEWGOODS(企业新品商品); GOODS_TYPE_DIRECTSELLING(企业直销商品)
     * @param unit 单位
     * @param goodsBody 商品描述
     * @return
     */
    @RequestMapping(value = "/goods/add" ,method = RequestMethod.POST)
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
                           String images){
        RestResult result = new RestResult();
        int res = goodsService.apiCreateGooods(goodsCategory1Id,goodsCategory2Id,goodsCategory3Id,
                name,price,carriage,storage,type,unit,goodsBody,images);
        return result;
    }

    /**
     * 更新商品
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
    @RequestMapping(value = "/goods/update" ,method = RequestMethod.POST)
    public Object updateGoods(Integer goodsCategory1Id,
                           Integer goodsCategory2Id,
                           Integer goodsCategory3Id,
                           String name,
                           BigDecimal price,
                           BigDecimal carriage,
                           Integer storage,
                           String type,
                           String unit,
                           String goodsBody,
                           String images){
        RestResult result = new RestResult();
        int res = goodsService.apiUpdateGoods(goodsCategory1Id,goodsCategory2Id,goodsCategory3Id,
                name,price,carriage,storage,type,unit,goodsBody,images);
        return result;
    }






    /**
     * 商家信息
     */
    @RequestMapping("/info")
    public Object sellerInfo(){
        RestResult result = new RestResult();
        ApiSellerInfo apiSellerInfo = storeService.getSellerInfo();
        return result;
    }


    /**
     * 申请成为商家
     * @return
     */
    @RequestMapping("/newStore")
    public Object applyStore(StoreJoinin storeJoinin) throws OptionException {
        RestResult result = new RestResult();
        int res = storeService.createStoreJoinin(storeJoinin);
        return result;
    }


    /**
     * 店铺支付宝提现
     * @param amount
     * @return
     * @throws OptionException
     */
    @RequestMapping(value = "/cash",method = RequestMethod.POST)
    public Object doCash(BigDecimal amount) throws OptionException, AlipayApiException {
        RestResult result = new RestResult();
        int res = storeAccountService.apisStoreDoCash(amount);
        return result;
    }


    /**
     * 修改或设置提现支付宝账户
     * @return
     */
    @RequestMapping(value = "/settingAlipay",method = RequestMethod.POST)
    public Object settingAlipay(String alipayAccount){
        RestResult result = new RestResult();
        int res = storeAccountService.apiSettingStoreAlipay(alipayAccount);
        return result;
    }

    /**
     * 获取现有提现支付宝账户
     * @return
     */
    @RequestMapping(value = "/getStoreAccount",method = RequestMethod.POST)
    public Object getStoreAccount() throws OptionException {
        RestResult result = new RestResult();
        StoreAccount storeAccount = storeAccountService.apiGetAlipayCashAccount();
        result.add("AlipayCashAccount", storeAccount);
        return result;
    }


}
