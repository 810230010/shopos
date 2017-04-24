package com.wuliangit.shopos.common.util;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.shiro.token.TokenManager;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.model.StoreMin;
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
     * @return
     */
    public static Member getCurrentMember(){
        TokenManager bean = SpringUtils.getBean(TokenManager.class);

        Session session = SecurityUtils.getSubject().getSession();
        Integer userId = (Integer)session.getAttribute(SESSION_CURRENT_USERID);

        String token = bean.getToken(userId);
        Object tokenData = bean.getTokenData(token);
        return (Member)tokenData;
    }

    /**
     * 获取当前店铺
     * @return
     */
    public static StoreMin getCurrentStore(){
        StoreMin store = (StoreMin) SecurityUtils.getSubject().getSession().getAttribute(CoreConstants.SESSION_CURRENT_STORE);
        return store;
    }

    /**
     * 获取当前session
     * @return
     */
    public static Session getSession(){
        Session session = SecurityUtils.getSubject().getSession();
        return session;
    }

}
