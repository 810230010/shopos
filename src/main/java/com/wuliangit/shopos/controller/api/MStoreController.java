package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.StoreJoinin;
import com.wuliangit.shopos.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nilme on 2017/3/27.
 */


@RestController
@RequestMapping("/api/v1/member")
public class MStoreController {

    @Autowired
    private StoreService storeService;


    /**
     * 申请成为商家
     * @return
     */
    @RequestMapping("/new-store")
    public Object applyStore(StoreJoinin storeJoinin){
        RestResult result = new RestResult();

        int res = storeService.createStoreJoinin(storeJoinin);

        return result;
    }
}
