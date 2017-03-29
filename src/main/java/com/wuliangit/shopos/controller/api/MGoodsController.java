package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.entity.Goods;
import com.wuliangit.shopos.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/30.
 */


@RestController
@RequestMapping("/api/v1/public")
public class MGoodsController {


    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/goods/search")
    public Object goodsSearch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(value = "searchKey", required = false) String searchKey,
                              @RequestParam(value = "order", required = false) String order) {
        RestResult result = new RestResult();
        ArrayList<ApiGoodsListDTO> goods =   goodsService.apiGoodsSearch(page, pageSize, searchKey, order);
        result.add("goods",goods);
        return result;
    }
}
