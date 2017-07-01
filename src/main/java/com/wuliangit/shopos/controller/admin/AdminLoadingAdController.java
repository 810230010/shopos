package com.wuliangit.shopos.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.dto.LoadingPicDTO;
import com.wuliangit.shopos.service.LoadingAdService;
import com.wuliangit.shopos.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wuliang01 on 2017/6/30.
 */
@Controller
@RequestMapping("/admin/advertisement")
public class AdminLoadingAdController {

    @Autowired
    private LoadingAdService loadingAdService;

    @RequestMapping("/adListPage")
    public String sendMessagePage(Model model){
        return "admin/loadingAd/ad_list_page";
    }

    @RequestMapping("/addLoadingAdPage")
    public String addLoadingAdPage(Model model){
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.BASE_URL);
        return "admin/loadingAd/add_loading_ad";
    }

    /**
     * 获取载进广告数据
     * @param page
     * @param pageSize
     * @param draw
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    @RequestMapping("/getLoadingAdListDate")
    @ResponseBody
    public HashMap<String, Object> getLoadingAdListDate(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page,
                                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                               @RequestParam(value = "draw",required = false) Integer draw,
                                               @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                               @RequestParam(value = "orderType", required = false) String orderType,
                                               @RequestParam(value = "searchKey", required = false) String searchKey){
        List<LoadingPicDTO> info = loadingAdService.getLoadingAdListDate();
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("draw",draw);
        result.put("recordsTotal",1);
        result.put("recordsFiltered",1);
        result.put("data",info);
        return result;
    }

    /**
     * 获取载进广告条数
     * @return
     */
    @RequestMapping("/getLoadingAdNumber")
    @ResponseBody
    public Object getLoadingAdNumber(){
        RestResult result = new RestResult();
        Integer info = loadingAdService.getLoadingAdNumber();
        result.add("data",info);
        return result;
    }

    /**
     * 添加载进图片
     * @param img
     * @return
     */
    @RequestMapping("/addLoadingPic")
    @ResponseBody
    public Object addLoadingPic(String img){
        RestResult result = new RestResult();
        Integer info = loadingAdService.addLoadingPic(img);
        return result;
    }

    /**
     * 删除载进图
     * @param id
     * @return
     */
    @RequestMapping("/deleteLoadingAd/{id}")
    @ResponseBody
    public RestResult deleteLoadingAd(@PathVariable("id")Integer id){
        RestResult result = new RestResult();
        Integer info = loadingAdService.deleteLoadingAd(id);
        return result;
    }

    /**
     * 修改状态
     * @param id
     * @param open
     * @return
     */
    @RequestMapping("/modifyStatus")
    @ResponseBody
    public RestResult modifyStatus(Integer id,Boolean open){
        RestResult result = new RestResult();
        Integer info = loadingAdService.modifyStatus(id,open);
        return result;
    }

}
