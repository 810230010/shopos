package com.wuliangit.shopos.controller.api;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.entity.Address;
import com.wuliangit.shopos.service.AddressService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * 用户地址相关
 * Created by nilme on 2017/3/27.
 */

@RestController
@RequestMapping("/api/v1/member/address")
public class MAddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private Mapper mapper;


    /**
     * 我的收货地址
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public Object addressList(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){
        RestResult result = new RestResult();
        ArrayList<Address> address = addressService.getAddressList(page,pageSize);
        result.add("addresses",address);
        return result;
    }

    /**
     * 获取地址
     * @param addressId
     * @return
     */
    @RequestMapping("/get")
    public Object getAddress(Integer addressId){
        RestResult result = new RestResult();
        Address address = addressService.getAddressById(addressId);
        result.add("address",address);
        return result;
    }

    /**
     * 设置默认收货地址
     * @param addressId 要设置成默认地址的地址id
     * @return
     */
    @RequestMapping("/default")
    public Object setDefaultAddress(Integer addressId){
        RestResult result = new RestResult();
        int res = addressService.setDefaultAddress(addressId);
        return result;
    }

    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    @RequestMapping("/delete")
    public Object deleteAddress(Integer addressId){
        RestResult result = new RestResult();
        int res = addressService.deleteAddress(addressId);
        return result;
    }

    /**
     * 更新收货地址
     * @param address
     * @return
     */
    @RequestMapping("/update")
    public Object updateAddress( Address address){
        RestResult result = new RestResult();
        int res = addressService.updateAddress(address);
        return result;
    }

    /**
     * 添加收货地址
     * @param address 地址信息
     * @return
     */
    @RequestMapping("/add")
    public Object addAddress(Address address){
        RestResult result = new RestResult();
        int res = addressService.createAddress(address);
        return result;
    }

    /**
     * 获取默认收货地址
     */
    @RequestMapping("/get-default")
    public Object getDefaultAddress(){
        RestResult result = new RestResult();
        Address address = addressService.getDefaultAddress();
        result.add("address",address);
        return result;
    }
}
