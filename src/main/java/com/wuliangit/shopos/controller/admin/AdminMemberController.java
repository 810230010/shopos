package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.MemberAuthListDTO;
import com.wuliangit.shopos.dto.MemberListDTO;
import com.wuliangit.shopos.entity.MemberAdvice;
import com.wuliangit.shopos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("/memberListPage")
    public String memberList(Model model){
        return "/admin/member/list";
    }

    /**
     * 获取会员实名列表页面
     * @param model
     * @return
     */
    @RequestMapping("/memberAuthListPage")
    public String memberAuthListPage(Model model){
        return "/admin/member/auth_list";
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
                                    @RequestParam(value = "draw",required = false) Integer draw,
                                    @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                    @RequestParam(value = "orderType", required = false) String orderType,
                                    @RequestParam(value = "searchKey", required = false) String searchKey){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<MemberListDTO> info = memberService.getMemberList(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult(info,draw);
    }

    @RequestMapping("/getMemberAuthList")
    @ResponseBody
    public PageResult getMemberAuthList(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "draw",required = false) Integer draw,
                                    @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                    @RequestParam(value = "orderType", required = false) String orderType,
                                    @RequestParam(value = "searchKey", required = false) String searchKey){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<MemberAuthListDTO> info = memberService.getMemberAuthList(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult(info,draw);
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
            result.add("code",RestResult.CODE_SERVERERROR);
            result.add("msg",RestResult.MSG_ERROR);
        }
        return result;
    }



     /** 更改会员状态
     * @param memberId
     * @param isCheck
     * @return
     */
    @RequestMapping("/memberAuthCheck")
    @ResponseBody
    public Object updateMemberState(Integer memberId, boolean isCheck){
        RestResult result = new RestResult();
        int res = memberService.updateMemberAuthState(memberId,isCheck);
        return result;
    }

}
