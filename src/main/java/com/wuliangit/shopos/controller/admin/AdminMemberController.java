package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.dto.MemberListDTO;
import com.wuliangit.shopos.entity.MemberAdvice;
import com.wuliangit.shopos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by pangweichao on 2017/5/5.
 */
@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 获取会员列表页面
     * @param model
     * @return
     */
    @RequestMapping("/memberList")
    public String memberList(Model model){
        return "/admin/member/list";
    }

    /**
     * 获取会员列表数据
     * @param page
     * @param pageSize
     * @param draw
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    @RequestMapping("/getMemberList")
    @ResponseBody
    public PageResult getMemberList(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                    @RequestParam("draw") Integer draw,
                                    @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                    @RequestParam(value = "orderType", required = false) String orderType,
                                    @RequestParam(value = "searchKey", required = false) String searchKey){
        List<MemberListDTO> info = memberService.getMemberList(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult<MemberListDTO>(info,draw);
    }

    /**
     * 删除会员
     * @param memberId
     * @return
     */
    @RequestMapping("/deleteMember")
    @ResponseBody
    public Object deleteMember(Integer memberId){
        RestResult result = new RestResult();
        Integer info = memberService.deleteMember(memberId);
        if(info != 1){
            result.put("code",RestResult.CODE_SERVERERROR);
            result.put("msg",RestResult.MSG_ERROR);
        }
        return result;
    }

    /**
     * 跳转到会员留言列表
     * @return
     */
    @RequestMapping("/adviceListPage")
    public String adviceListPage() {
        return "/admin/member/advice_list";
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
        List<MemberAdvice> advices = memberService.getMemberAdviceList(page, pageSize, orderColumn, orderType, searchKey);
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
    public String updateAdviceScanStatus(Integer adviceId, String type){
        if("0".equals(type)){
            memberService.updateAdviceLookStatus(adviceId);
        }else{
            memberService.deleteAdvice(adviceId);
        }
        return "ok";
    }

}
