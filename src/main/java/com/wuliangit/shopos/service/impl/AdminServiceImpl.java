package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.util.PasswordHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.AdminMapper;
import com.wuliangit.shopos.dto.AdminDTO;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nilme on 2017/3/15.
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Set<String> getRoles(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        return roles;
    }

    @Override
    public Set<String> getPermissions(String username) {
        return null;
    }

    @Override
    public Admin getByUsername(String username) {
        return adminMapper.getByUsername(username);
    }

    @Override
    public int update(AdminDTO admin, String newPass) {
        Admin currentAdmin = WebUtil.getCurrentAdmin();
        if (!StringUtils.isEmpty(admin.getEmail())){
            currentAdmin.setEmail(admin.getEmail());
        }
        //更新密码
        if (!StringUtils.isEmpty(newPass)){
            currentAdmin.setPassword(PasswordHelper.generatePassword(newPass,currentAdmin.getSalt()));
        }
        int res = adminMapper.updateByPrimaryKeySelective(currentAdmin);

        //更新缓存
        WebUtil.getSession().removeAttribute(CoreConstants.SESSION_CURRENT_ADMIN);
        WebUtil.getSession().setAttribute(CoreConstants.SESSION_CURRENT_ADMIN, currentAdmin);

        return res;
    }
}
