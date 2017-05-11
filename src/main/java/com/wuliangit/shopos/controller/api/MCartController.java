package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiCartDTO;
import com.wuliangit.shopos.dto.ApiCartListDTO;
import com.wuliangit.shopos.entity.Cart;
import com.wuliangit.shopos.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车相关
 * Created by nilme on 2017/3/29.
 */

@RestController
@RequestMapping("/api/v1/member/cart")
public class MCartController {

    @Autowired
    private CartService cartService;

    /**
     * 购物车商品列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public Object getCartList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "50") Integer pageSize) {
        RestResult result = new RestResult();
        ArrayList<ApiCartDTO> carts = cartService.getCartList(page, pageSize);

        List<ApiCartListDTO> apiCartListDTOS = new ArrayList<>();

        for (ApiCartDTO cart : carts) {
            Integer storeId = cart.getStoreId();
            ApiCartListDTO sotore = null;
            for (ApiCartListDTO apiCartListDTO : apiCartListDTOS) {
                if (apiCartListDTO.getStoreId() == storeId){
                    sotore = apiCartListDTO;
                    break;
                }
            }
            if (sotore == null){
                sotore = new ApiCartListDTO();
                sotore.setStoreId(storeId);
                sotore.setStoreName(cart.getStoreName());
                List<ApiCartDTO> newCarts = new ArrayList<>();
                newCarts.add(cart);
                sotore.setCarts(newCarts);
                apiCartListDTOS.add(sotore);
            }else{
                sotore.getCarts().add(cart);
            }
        }

        result.add("carts", apiCartListDTOS);
        return result;
    }


    /**
     * 购物车移除商品
     *
     * @param cartId
     * @return
     */
    @RequestMapping("/delete")
    public Object deleteCartGoods(@RequestParam(value = "cartId", required = true) Integer cartId) {
        RestResult result = new RestResult();
        int res = cartService.deleteCartGoods(cartId);
        return result;
    }

    /**
     * 添加购物车商品
     * @param goodsId
     * @param goodsNum
     * @return
     */
    @RequestMapping("/add")
    public Object addCartGoods(@RequestParam(value = "goodsId", required = true) Integer goodsId,
                               @RequestParam(value = "goodsSkuId", required = true) Integer goodsSkuId,
                               @RequestParam(value = "goodsNum", required = false, defaultValue = "1") Integer goodsNum) {
        RestResult result = new RestResult();
        int res = cartService.addCartGoods(goodsId,goodsSkuId,goodsNum);
        return result;
    }


    /**
     * 购物车更新商品数量
     * @param cartId
     * @param goodsNum
     * @return
     */
    @RequestMapping("/update")
    public Object updateCartGoods(@RequestParam(value = "cartId", required = true) Integer cartId,
                                  @RequestParam(value = "goodsNum", required = false, defaultValue = "1") Integer goodsNum){
        RestResult result = new RestResult();
        int res = cartService.updateCartGoods(cartId,goodsNum);
        return result;
    }

}
