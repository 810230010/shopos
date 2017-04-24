package com.wuliangit.shopos.common.shiro.realm;

import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;


/**
 * Created by nilme on 2017/4/23.
 */
public class CustomizedModularRealmAuthorizer extends ModularRealmAuthorizer {

    @Override
    public boolean hasRole(PrincipalCollection principals, String roleIdentifier) {
        assertRealmsConfigured();
        principals.getPrimaryPrincipal();
        Set<String> realmNames = principals.getRealmNames();
        String realmName = realmNames.iterator().next();
        for (Realm realm : getRealms()) {

            if (realm.getName().equals(realmName)){
                if (!(realm instanceof Authorizer)) continue;
                if (((Authorizer) realm).hasRole(principals, roleIdentifier)) {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean isPermitted(PrincipalCollection principals, Permission permission) {
        assertRealmsConfigured();
        for (Realm realm : getRealms()) {
            if (!(realm instanceof Authorizer)) continue;
            if (((Authorizer) realm).isPermitted(principals, permission)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        assertRealmsConfigured();
        for (Realm realm : getRealms()) {
            if (!(realm instanceof Authorizer)) continue;
            if (((Authorizer) realm).isPermitted(principals, permission)) {
                return true;
            }
        }
        return false;
    }

}
