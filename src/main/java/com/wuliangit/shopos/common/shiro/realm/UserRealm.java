package com.wuliangit.shopos.common.shiro.realm;

import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.service.AdminService;
import com.wuliangit.shopos.service.MemberService;
import com.wuliangit.shopos.service.SellerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private MemberService memberService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private AdminService adminService;

    @Override
    public String getName() {
        return "app";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //支持 UsernamePasswordToken 类型的 Token
        return token instanceof UserToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Object principal = principals.getPrimaryPrincipal();

        if (principal instanceof Admin) {
            authorizationInfo.setRoles(adminService.getRoles(((Admin) principal).getUsername()));
            authorizationInfo.setStringPermissions(adminService.getPermissions(((Admin) principal).getUsername()));
            return authorizationInfo;
        } else if (principal instanceof Member) {
            authorizationInfo.setRoles(memberService.getRoles(((Member) principal).getUsername()));
            authorizationInfo.setStringPermissions(memberService.getPermissions(((Member) principal).getUsername()));
            return authorizationInfo;
        } else if (principal instanceof Seller) {
            authorizationInfo.setRoles(sellerService.getRoles(((Seller) principal).getUsername()));
            authorizationInfo.setStringPermissions(sellerService.getPermissions(((Seller) principal).getUsername()));
            return authorizationInfo;
        }
        return null;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo authenticationInfo = null;
        UserToken userToken = (UserToken) token;
        if (userToken.getUserType() == UserToken.UserType.MEMBER) {
            Member user = null;
            if (userToken.getLoginType() == UserToken.LoginType.WX) {
                user = memberService.getByOpenid(userToken.getUsername());
            } else {
                user = memberService.getByUsername(userToken.getUsername());
            }
            if (user == null) {
                throw new UnknownAccountException();
            }
            authenticationInfo = new SimpleAuthenticationInfo(
                    user,
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
                    user, //用户名
                    user.getPassword(), //密码
                    ByteSource.Util.bytes(user.getSalt()),
                    getName()
            );
        } else if (userToken.getUserType() == UserToken.UserType.STORE) {
            Seller seller = sellerService.getByUsername(userToken.getUsername());
            if (seller == null) {
                throw new UnknownAccountException();
            }
            authenticationInfo = new SimpleAuthenticationInfo(
                    seller,
                    seller.getPassword(),
                    ByteSource.Util.bytes(seller.getSalt()),
                    getName()
            );
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
