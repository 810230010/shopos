package com.wuliangit.shopos.service;

import com.wuliangit.shopos.entity.Address;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/27.
 */
public interface AddressService {

    /**
     * 获取用户地址列表
     * @param page
     * @param pageSize
     * @return
     */
    ArrayList<Address> getAddressList(Integer page, Integer pageSize);

    /**
     * 设置默认地址
     * @param addressId
     * @return
     */
    int setDefaultAddress(Integer addressId);

    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    int deleteAddress(Integer addressId);

    /**
     * 更新收货地址
     * @param address
     * @return
     */
    int updateAddress(Address address);

    /**
     * 添加收货地址
     * @param address
     * @return
     */
    int createAddress(Address address);

    /**
     * 获取默认收货地址
     * @return
     */
    Address getDefaultAddress();

    /**
     * 通过id获取地址
     * @param addressId
     * @return
     */
    Address getAddressById(Integer addressId);
}
