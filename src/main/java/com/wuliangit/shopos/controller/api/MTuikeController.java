package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.EarningsDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.MemberService;
import com.wuliangit.shopos.service.TuikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Member memberUpdate = WebUtil.getCurrentMember();
        memberUpdate.setType(POJOConstants.USER_TYPE_PRE_TUIKE);
        memberService.updateMember(memberUpdate);
        return result;
    }

    /**
     * 获取推客收益
     * @return
     */
    @RequestMapping("/tuike/earnings")
    public Object getEarnings() {
        RestResult result = new RestResult();
        EarningsDTO earnings = tuikeService.getEarnings();

        result.add("earnings",earnings);

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
}
