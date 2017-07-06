package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.BannerDTO;
import com.wuliangit.shopos.entity.Banner;
import com.wuliangit.shopos.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author boom
 * @description 广告相关接口
 * @create 2017-06-02 14:36
 **/
@Controller
@RequestMapping("/admin/banner")
public class AdminBannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/bannerListPage")
    public String bannerListPage(Model model){
        return "admin/banner/list";
    }

    @RequestMapping("/addBannerPage")
    public String addBannerPage(Model model){
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.getBaseUrl());
        return "admin/banner/add_banner";
    }

    /**
     * 获取banner图的列表
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("getBannerListDate")
    @ResponseBody
    public Object getBannerListDate(@RequestParam("draw") int draw,
                                    @RequestParam(value = "searchKey", required = false) String searchKey,
                                    @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                    @RequestParam(value = "orderType", required = false) String orderType,
                                    @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<BannerDTO> banners = bannerService.getBannerListDate(searchKey,orderColumn,orderType,page,pageSize);
        return new PageResult<BannerDTO>(banners,draw);
    }

    /**
     * @Description: 添加banner图
     * @Author: pangweichao
     * @Date: 15:29 2017/6/2
     * @Param: [img]
     * @return: java.lang.Object
     */
    @RequestMapping("/addBanner")
    @ResponseBody
    public Object addBanner(String img){
        RestResult result = new RestResult();
        Integer info = bannerService.addBanner(img);
        return result;
    }

    /**
     * @Description: 删除banner图
     * @Author: pangweichao
     * @Date: 15:51 2017/6/2
     * @Param: [tBannerId]
     * @return: java.lang.Object
     */
    @RequestMapping(value = "/deleteBanner/{tBannerId}")
    @ResponseBody
    public Object deleteBanner(@PathVariable("tBannerId") Integer tBannerId){
        RestResult result = new RestResult();
        Integer info = bannerService.deleteBanner(tBannerId);
        return result;
    }

    /**
     * 更改状态
     * @param tBannerId
     * @param statusFlag
     * @return
     */
    @RequestMapping("/modifyStatus")
    @ResponseBody
    public Object modifyStatus(Integer tBannerId,String statusFlag){
        RestResult result = new RestResult();
        Integer info = bannerService.changeStatus(tBannerId,statusFlag);
        return result;
    }

}
