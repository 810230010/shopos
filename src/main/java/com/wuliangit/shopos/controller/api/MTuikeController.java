package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.api.ApiTuikeShareDataDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Tuike;
import com.wuliangit.shopos.dto.api.ApiTuikeShareDTO;
import com.wuliangit.shopos.service.MemberService;
import com.wuliangit.shopos.service.TuikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nilme on 2017/3/27.
 */

@RestController
@RequestMapping("/api/v1/member")
public class MTuikeController {


    @Autowired
    private TuikeService tuikeService;

    @Autowired
    private MemberService memberService;

    /**
     * 申请成为推客
     * @return
     */
    @RequestMapping("/tuike/apply")
    public Object tuikeApply(){
        RestResult result = new RestResult();
        Member member = WebUtil.getCurrentMember();

        if (member.getAuthState().equals(POJOConstants.AUTHED) ){
            member.setType(POJOConstants.USER_TYPE_PRE_TUIKE);
            memberService.updateMember(member);
        }else{
            result.setCode(500);
            result.setMsg("请先实名认证，再申请成为推客！");
        }

        return result;
    }

    /**
     * 获取推客信息
     * @return
     */
    @RequestMapping("/tuike/earnings")
    public Object getEarnings() {
        RestResult result = new RestResult();
        Tuike currentTuike = WebUtil.getCurrentTuike();
        result.add("tuike",currentTuike);
        return result;
    }

    /**
     * 推客提现
     * @return
     */
    @RequestMapping("/tuike/earnings/cash")
    public Object earningsCash(){
        RestResult result = new RestResult();

        boolean res = tuikeService.earningsCash();

        return result;
    }

    /**
     * 获取tuikecode
     * @return
     */
    @RequestMapping("/tuike/getTuikeCode")
    public Object getTuikeCode(Integer memberId){
        RestResult result = new RestResult();
        String code = tuikeService.getTuikeCode(memberId);
        result.add("tuikeCode",code);
        return result;
    }

    /**
     * 获取成功分享的数据
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/tuike/getShareInfo")
    public Object getShareInfo(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                               Integer tuikeId){
        RestResult result = new RestResult();
        List<ApiTuikeShareDataDTO> shareInfo = tuikeService.getShareInfo(page, pageSize,tuikeId);
        result.add("shareInfo", shareInfo);
        return result;
    }

}
