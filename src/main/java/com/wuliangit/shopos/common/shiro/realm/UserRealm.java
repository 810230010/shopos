package com.wuliangit.shopos.common.shiro.realm;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.shiro.token.TokenManager;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.AdminService;
import com.wuliangit.shopos.service.MemberService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class UserRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private MemberService memberService;

    @Override
    public String getName() {
        return "userRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //支持 UsernamePasswordToken 类型的 Token
        return token instanceof UserToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        HashMap<String, Object> user = (HashMap) principals;
        String username = (String) user.get("username");
        UserToken.UserType userType = (UserToken.UserType) user.get("userType");
        SimpleAuthorizationInfo authorizationInfo = null;
        if (userType == UserToken.UserType.MEMBER) {
            authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.setRoles(memberService.getRoles(username));
            authorizationInfo.setStringPermissions(memberService.getPermissions(username));
        } else if (userType == UserToken.UserType.ADMIN) {
            authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.setRoles(adminService.getRoles(username));
            authorizationInfo.setStringPermissions(adminService.getPermissions(username));
        }
        return authorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo authenticationInfo = null;
        UserToken userToken = (UserToken) token;
        if (userToken.getUserType() == UserToken.UserType.MEMBER) {
            Member user = null;

            if (userToken.getLoginType() == UserToken.LoginType.WX){
                user = memberService.getByOpenid(userToken.getUsername());
            }else if(userToken.getLoginType() == UserToken.LoginType.APP){
                user = memberService.getByUsername(userToken.getUsername());
            }else if(userToken.getLoginType() == UserToken.LoginType.TOKEN){

            }

            if (user == null) {
                throw new UnknownAccountException();
            }
            authenticationInfo = new SimpleAuthenticationInfo(
                    user.getUsername(),
                    user.getPasswd(),
                    ByteSource.Util.bytes(user.getSalt()),
                    getName()
            );
        } else if (userToken.getUserType() == UserToken.UserType.ADMIN) {
            Admin user = adminService.getByUsername(userToken.getUsername());
            if ((user == null)) {
                throw new UnknownAccountException();
            }
            authenticationInfo = new SimpleAuthenticationInfo(
                    user.getUsername(), //用户名
                    user.getPassword(), //密码
                    ByteSource.Util.bytes(user.getSalt()),
                    getName()
            );
            SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_USER, user);
        }
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
