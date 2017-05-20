package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.ApiStoreDTO;
import com.wuliangit.shopos.dto.ApiStoreListDTO;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.service.CollectService;
import com.wuliangit.shopos.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by nilme on 2017/3/27.
 */


@RestController
@RequestMapping("/api/v1/public/store")
public class MStoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private CollectService collectService;

    /**
     * 申请成为商家
     * @return
     */
    @RequestMapping("/newStore")
    public Object applyStore(StoreJoinin storeJoinin){
        RestResult result = new RestResult();
        int res = storeService.createStoreJoinin(storeJoinin);
        return result;
    }

    /**
     * 搜索店铺接口
     * @param page 页码
     * @param pageSize 页大小
     * @param searchKey  搜索关键词
     * @param order SALES 销量排序, GRADE 店铺等级排序
     * @param type 店铺类型；STORE:普通商家；ENTERPRISE：企业
     * @return
     */
    @RequestMapping("/search")
    public Object goodsSearch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(value = "searchKey", required = false) String searchKey,
                              @RequestParam(value = "order", required = false) String order,
                              @RequestParam(value = "type", required = false) String type) {
        RestResult result = new RestResult();
        List<ApiStoreListDTO> stores = storeService.apiStoreSearch(page, pageSize, searchKey, order, type);
        result.add("stores", stores);
        return result;
    }


    /**
     * 获取店铺详情
     * @param storeId
     * @return
     */
    @RequestMapping("/get")
    public Object getStore(Integer storeId){
        RestResult result = new RestResult();
        ApiStoreDTO store = storeService.apiGetStoreDTO(storeId);
        boolean isCollect = collectService.isCollectStore(storeId);
        result.add("store",store);
        result.add("isCollect", isCollect);
        return result;
    }



}
