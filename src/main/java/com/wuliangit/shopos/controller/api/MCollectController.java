package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.core.controller.RestResult;
import com.wuliangit.shopos.dto.CollectGoodsDTO;
import com.wuliangit.shopos.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Object getCollectGoodsList() {
        RestResult result = new RestResult();
        ArrayList<CollectGoodsDTO> collectGoods = collectService.getCollectGoodsList();
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
    public Object addCollectGoods(Integer goodsId) {
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


}
