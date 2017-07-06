package com.wuliangit.shopos.common.util;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.shiro.token.TokenManager;
import com.wuliangit.shopos.dto.api.ApiSellerInfo;
import com.wuliangit.shopos.entity.*;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.StoreService;
import com.wuliangit.shopos.service.TuikeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import static com.wuliangit.shopos.common.CoreConstants.SESSION_CURRENT_USERID;

/**
 * 项目公共方法
 * Created by nilme on 2017/3/22.
 */
public class WebUtil {

    /**
     * 获取当前用户
     *
     * @return
     */
    public static Member getCurrentMember() {
        TokenManager bean = SpringUtils.getBean(TokenManager.class);

        Session session = SecurityUtils.getSubject().getSession();
        Integer userId = (Integer) session.getAttribute(SESSION_CURRENT_USERID);

        String token = bean.getToken(userId);
        Object tokenData = bean.getTokenData(token);
        return (Member) tokenData;
    }

    /**
     * 获取当前店铺卖家
     *
     * @return
     */
    public static Seller getCurrentSeller() {
        Seller seller = (Seller) SecurityUtils.getSubject().getSession().getAttribute(CoreConstants.SESSION_CURRENT_SELLER);
        return seller;
    }

    /**
     * 获取当前店铺
     *
     * @return
     */
    public static StoreMin getCurrentStore() {
        StoreMin store = (StoreMin) SecurityUtils.getSubject().getSession().getAttribute(CoreConstants.SESSION_CURRENT_STORE);
        return store;
    }

    /**
     * 获取当前管理员
     *
     * @return
     */
    public static Admin getCurrentAdmin() {
        Admin admin = (Admin) SecurityUtils.getSubject().getSession().getAttribute(CoreConstants.SESSION_CURRENT_ADMIN);
        return admin;
    }

    /**
     * 获取当前session
     *
     * @return
     */
    public static Session getSession() {
        Session session = SecurityUtils.getSubject().getSession();
        return session;
    }

    /**
     * 移动端店铺操作获取当前店铺信息
     */
    public static Store mobileGetCurrentStore() {
        Member member = WebUtil.getCurrentMember();
        StoreService storeService = SpringUtils.getBean(StoreService.class);
        return storeService.getStoreByBindMemberUsername(member.getUsername());
    }


    /**
     * 获取当前移动端的推客信息
     *
     * @return
     */
    public static Tuike getCurrentTuike() {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute(SESSION_CURRENT_USERID);
        TuikeService tuikeService = SpringUtils.getBean(TuikeService.class);
        Tuike tuike = tuikeService.getTuikeByMemberId(userId);
        return tuike;

    }
}
