package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.MemberListDTO;
import com.wuliangit.shopos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wuliang01 on 2017/6/30.
 */
@Controller
@RequestMapping("/admin/advertisement")
public class AdminAdvertisementController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/adListPage")
    public String sendMessagePage(Model model){
        return "admin/advertisement/ad_list_page";
    }

    @RequestMapping("/getAdvertisementListDate")
    @ResponseBody
    public PageResult getAdvertisementListDate(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page,
                                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                               @RequestParam(value = "draw",required = false) Integer draw,
                                               @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                               @RequestParam(value = "orderType", required = false) String orderType,
                                               @RequestParam(value = "searchKey", required = false) String searchKey){
        List<MemberListDTO> info = memberService.getMemberList(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult(info,draw);
    }

}
