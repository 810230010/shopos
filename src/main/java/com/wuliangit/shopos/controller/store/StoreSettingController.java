package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.StoreUpdateDTO;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.MemberService;
import com.wuliangit.shopos.service.SMSService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nilme on 2017/4/28.
 */

@Controller
@RequestMapping("/store/setting")
public class StoreSettingController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private Mapper mapper;
    @Autowired
    private SMSService smsService;
    @Autowired
    private MemberService memberService;

    /**
     * 店铺信息修改页面
     * @param model
     * @return
     */
    @RequestMapping("")
    public String indexPage(Model model){
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain",QiNiuUtils.BASE_URL);

        StoreMin storeMin = WebUtil.getCurrentStore();
        Store store = storeService.getStoreByStoreId(storeMin.getStoreId());
        model.addAttribute("store",store);
        return "/store/setting/index";
    }

    /**
     * 店铺信息修改
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Object setting(StoreUpdateDTO storeDto,String checkCode){
        RestResult result = new RestResult();
        if (!StringUtils.isEmpty(storeDto.getBindMemberUsername())){
            String checkCode1 = smsService.getCheckCode(storeDto.getBindMemberUsername());
            if (!checkCode1.equals(checkCode)){
                result.setCode(RestResult.CODE_SERVERERROR);
                result.setMsg("验证码不正确");
                return result;
            }
        }

        Store store  = mapper.map(storeDto, Store.class);
        int res = storeService.updateStore(store);
        return result;
    }

    @RequestMapping("/getBindCode")
    @ResponseBody
    public Object getBindCode(String phone){
        RestResult result = new RestResult();

        Member member = memberService.getByUsername(phone);

        if (member==null){
            result.setCode(RestResult.CODE_SERVERERROR);
            result.setMsg("会员不存在");
            return result;
        }

        Store store = storeService.getStoreByBindMemberUsername(phone);

        if(store!=null){
            StoreMin currentStore = WebUtil.getCurrentStore();
            if (!currentStore.getStoreId().equals(store.getStoreId())){
                result.setCode(RestResult.CODE_SERVERERROR);
                result.setMsg("该会员已经绑定了店铺");
                return result;
            }
        }

        boolean res = smsService.sendStoreBindCode(phone);
        if (res) {
            return result;
        } else {
            result.setCode(RestResult.CODE_SERVERERROR);
            result.setMsg("修改面密码验证码获取失败");
            return result;
        }
    }

}
