package com.wuliangit.shopos.common.util;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.entity.Member;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

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
        Member member = (Member) SecurityUtils.getSubject().getSession().getAttribute(CoreConstants.SESSION_CURRENT_USER);
        return member;
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
