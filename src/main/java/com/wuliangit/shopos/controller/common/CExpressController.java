package com.wuliangit.shopos.controller.common;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.Express;
import com.wuliangit.shopos.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nilme on 2017/4/28.
 */

@Controller
@RequestMapping("/common")
public class CExpressController {

    @Autowired
    private ExpressService expressService;

    /**
     * 图片删除什么都不做
     * @return
     */
    @RequestMapping("/donothing")
    @ResponseBody
    public Object donothing(){
        RestResult result = new RestResult();
        return result;
    }

    /**
     * 获取快递公司信息
     * @return
     */
    @RequestMapping("/expressList")
    @ResponseBody
    public Object getExpressList(String searchkey){
        RestResult result = new RestResult();
        List<Express> expressList = expressService.getExpressList(searchkey);
        result.add("expressList",expressList);
        return result;
    }

}
