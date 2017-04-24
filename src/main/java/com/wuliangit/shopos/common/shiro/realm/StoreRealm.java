package com.wuliangit.shopos.common.shiro.realm;

import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.MemberService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class StoreRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(StoreRealm.class);

    @Autowired
    private MemberService memberService;
    @Autowired
    private StoreService storeService;

    @Override
    public String getName() {
        return "store";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //支持 UsernamePasswordToken 类型的 Token
        return token instanceof UserToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String username = (String) principals.getPrimaryPrincipal();
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.setRoles(storeService.getRoles(username));
//        authorizationInfo.setStringPermissions(storeService.getPermissions(username));
        return null;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo authenticationInfo = null;
        UserToken userToken = (UserToken) token;
        Member member = memberService.getByUsername(userToken.getUsername());

        if (member == null) {
            throw new UnknownAccountException();
        }

        StoreMin storeMin = storeService.getStoreMin(member.getMemberId());

        if (storeMin == null) {
            throw new UnknownAccountException();
        }

        authenticationInfo = new SimpleAuthenticationInfo(
                member,
                member.getPasswd(),
                ByteSource.Util.bytes(member.getSalt()),
                getName()
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
