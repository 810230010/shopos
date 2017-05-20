package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.AdminRoleDTO;
import com.wuliangit.shopos.entity.AdminRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRoleMapper extends BaseMapper<AdminRole, Integer> {
    /**
     * 获取管理员所有角色列表
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
     List<AdminRoleDTO> searchAdminRoleList(@Param("searchKey") String searchKey,
                                            @Param("orderColumn") String orderColumn,
                                            @Param("orderType")String orderType);

}