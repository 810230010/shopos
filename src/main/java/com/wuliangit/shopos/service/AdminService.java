package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.AdminDTO;
import com.wuliangit.shopos.dto.AdminRoleDTO;
import com.wuliangit.shopos.dto.AdminUpdateDTO;
import com.wuliangit.shopos.entity.Admin;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by nilme on 2017/3/15.
 */
public interface AdminService {
    /**
     * 获取角色
     * @param username
     * @return
     */
    Set<String> getRoles(String username);

    /**
     * 获取权限
     * @param username
     * @return
     */
    Set<String> getPermissions(String username);

    /**
     * 通过用户名查找管理员
     * @param username
     * @return
     */
    Admin getByUsername(String username);

    /**
     * 查找所有管理员
     * @param page
     * @param pageSize
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    List<AdminDTO> searchAdminList(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey);

    /**
     * 获得所有可用管理员角色列表
     * @return
     */
    ArrayList<AdminRoleDTO> getAllAdminRoles();

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    int createAdmin(Admin admin);

    AdminDTO getAdminById(Integer adminId);

    /**
     * 更新用户信息
     * @param admin
     * @param newPass
     * @return
     */
    int update(AdminDTO admin, String newPass);

    /**
     * 最大的管理员修改其他管理员信息
     * @param admin
     * @return
     */
    int updateOtherAdminInfo(AdminUpdateDTO admin);

    int deleteAdmin(Integer adminId);
}
