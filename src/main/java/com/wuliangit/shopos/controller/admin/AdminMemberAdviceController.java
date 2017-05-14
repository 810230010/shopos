package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.MemberAdvice;
import com.wuliangit.shopos.service.MemberAdviceService;
import com.wuliangit.shopos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nilme on 2017/5/14.
 */

@Controller
@RequestMapping("/admin/memberAdvice")
public class AdminMemberAdviceController {

    @Autowired
    private MemberAdviceService memberAdviceService;

    /**
     * 跳转到会员留言列表
     * @return
     */
    @RequestMapping("/ListPage")
    public String adviceListPage() {
        return "/admin/memberAdvice/list";
    }
    /**
     * 会员留言列表
     * @param page
     * @param pageSize
     * @param draw
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    @RequestMapping("/adviceList")
    @ResponseBody
    public Object getAdviceList(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                @RequestParam("draw") Integer draw,
                                @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                @RequestParam(value = "orderType", required = false) String orderType,
                                @RequestParam(value = "searchKey", required = false) String searchKey) {
        List<MemberAdvice> advices = memberAdviceService.getMemberAdviceList(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult<MemberAdvice>(advices, draw);
    }

    /**
     * 更改留言状态
     * @param adviceId
     * @param type 0表示修改为已读  1表示删除标志
     * @return
     */
    @RequestMapping("/updateAdviceStatus")
    @ResponseBody
    public Object updateAdviceScanStatus(Integer adviceId, String type) {
        RestResult result = new RestResult();
        if ("0".equals(type)) {
            memberAdviceService.updateAdviceLookStatus(adviceId);
        } else {
            memberAdviceService.deleteAdvice(adviceId);
        }
        return result;
    }
}
