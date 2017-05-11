package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiCollectGoodsDTO;
import com.wuliangit.shopos.dto.ApiCollectStoreDTO;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/29.
 */
@RestController
@RequestMapping("/api/v1/member/collect")
public class MCollectController {

    @Autowired
    private CollectService collectService;

    /**
     * 用户收藏商品列表
     *
     * @return
     */
    @RequestMapping("/goods/list")
    public Object getCollectGoodsList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        RestResult result = new RestResult();
        ArrayList<ApiCollectGoodsDTO> collectGoods = collectService.getCollectGoodsList(page, pageSize);
        result.add("collectGoods", collectGoods);
        return result;
    }

    /**
     * 用户收藏商品
     *
     * @param goodsId
     * @return
     */
    @RequestMapping("/goods/add")
    public Object addCollectGoods(Integer goodsId) throws Exception {
        RestResult result = new RestResult();
        int res = collectService.addCollectGoods(goodsId);
        return result;
    }

    /**
     * 删除收藏商品
     *
     * @param goodsId
     * @return
     */
    @RequestMapping("/goods/delete")
    public Object deleteCollectGoods(Integer goodsId) {
        RestResult result = new RestResult();
        int res = collectService.deleteCollectGoods(goodsId);
        return result;
    }

    /**
     * 用户收藏店铺列表
     *
     * @return
     */
    @RequestMapping("/store/list")
    public Object getCollectStoreList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        RestResult result = new RestResult();
        ArrayList<ApiCollectStoreDTO> collectStores = collectService.getCollectStireList(page, pageSize);
        result.add("collectStores", collectStores);
        return result;
    }

    /**
     * 用户添加收藏店铺
     * @param storeId
     * @return
     */
    @RequestMapping("/store/add")
    public Object addCollectStore(Integer storeId) throws Exception{
        RestResult result = new RestResult();
        int res = collectService.addCollectStore(storeId);
        return result;
    }

    /**
     * 删除收藏店铺
     * @param storeId
     * @return
     */
    @RequestMapping("/store/delete")
    public Object deleteCollectStore(Integer storeId){
        RestResult result = new RestResult();
        int res = collectService.deleteCollectStore(storeId);
        return result;
    }



}
