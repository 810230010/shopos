package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.entity.Store;
import com.wuliangit.shopos.model.StoreBrand;
import com.wuliangit.shopos.model.StoreUser;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface StoreMapper extends BaseMapper<Store, Integer> {
    /**
     * 通过用户名获取店铺简要信息
     * @param memberId
     * @return
     */
    StoreUser getStoreUser(Integer memberId);

    /**
     * 获得某个店铺品牌
     * @param storeId
     * @return
     */
    List<StoreBrand> getStoreBrands(@Param("storeId") Integer storeId, @Param("searchKey") String searchKey);

    /**
     * 更改店铺某品牌上下架状态
     * @param id
     * @param status
     * @return
     */
    int updateBrandStatusByPrimaryKey(@Param("id") Integer id, @Param("status") String status);

    /**
     * 删除某个店铺的品牌
     * @param id
     * @return
     */
    int deleteStoreBrand(@Param("id") Integer id);

    /**
     * 查询所有品牌
     * @return
     */
    ArrayList<Brand> queryAllBrands();

    /**
     * 店铺入驻品牌
     * @param storeId
     * @param brandId
     * @return
     */
    int addStoreBrand(@Param("storeId") Integer storeId, @Param("brandId") Integer brandId);
}