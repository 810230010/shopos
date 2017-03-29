package com.wuliangit.shopos.core.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by nilme on 2017/3/29.
 */
public class OnlineSessionDAO extends EnterpriseCacheSessionDAO {

    @Autowired
    private OnlineSessionFactory onlineSessionFactory;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return onlineSessionFactory.createSession(sessionId);
    }

}
