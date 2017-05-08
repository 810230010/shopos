package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.AddressMapper;
import com.wuliangit.shopos.entity.Address;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/27.
 */

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public ArrayList<Address> getAddressList(Integer page, Integer pageSize) {
        Member member = WebUtil.getCurrentMember();
        PageHelper.startPage(page,pageSize);
        ArrayList<Address> addresses = addressMapper.getMemberAddressList(member.getMemberId());
        return addresses;
    }

    @Override
    @Transactional
    public int setDefaultAddress(Integer addressId) {
        Member user = WebUtil.getCurrentMember();
        int res = addressMapper.cleanDefaultAddress(user.getMemberId());
        Address address = addressMapper.selectByPrimaryKey(addressId);
        address.setIsDefault(true);
        addressMapper.updateByPrimaryKeySelective(address);
        return 1;
    }

    @Override
    public int deleteAddress(Integer addressId) {
        return addressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public int updateAddress(Address address) {
        if (address.getIsDefault()){
            Member currentMember = WebUtil.getCurrentMember();
            addressMapper.cleanDefaultAddress(currentMember.getMemberId());
        }
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public int createAddress(Address address) {
        Member currentMember = WebUtil.getCurrentMember();
        address.setMemberId(currentMember.getMemberId());
        return addressMapper.insertSelective(address);
    }

    @Override
    public Address getDefaultAddress() {
        Member user = WebUtil.getCurrentMember();
        return addressMapper.getDefaultAddress(user.getMemberId());
    }

}
