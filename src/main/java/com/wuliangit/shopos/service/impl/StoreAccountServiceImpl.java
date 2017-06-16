package com.wuliangit.shopos.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayFundTransToaccountTransferModel;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.StoreAccountLogMapper;
import com.wuliangit.shopos.dao.StoreAccountMapper;
import com.wuliangit.shopos.dao.StoreCashMapper;
import com.wuliangit.shopos.dto.ApiSellerInfo;
import com.wuliangit.shopos.dto.StoreAccountListDTO;
import com.wuliangit.shopos.dto.StoreCashListDTO;
import com.wuliangit.shopos.dto.TuikeCheckListDTO;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.entity.StoreAccount;
import com.wuliangit.shopos.entity.StoreAccountLog;
import com.wuliangit.shopos.entity.StoreCash;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.StoreAccountService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by nilme on 2017/5/27.
 */

@Service
public class StoreAccountServiceImpl implements StoreAccountService {

    @Autowired
    private StoreAccountLogMapper storeAccountLogMapper;
    @Autowired
    private StoreCashMapper storeCashMapper;
    @Autowired
    private StoreAccountMapper storeAccountMapper;
    @Autowired
    private StoreService storeService;


    @Override
    public List<StoreAccountLog> getAccountHistoryList(Integer page, Integer pageSize, String orderColumn, String orderType) {
        PageHelper.startPage(page, pageSize);
        StoreMin store = WebUtil.getCurrentStore();
        List<StoreAccountLog> storeAccountLogs = storeAccountLogMapper.getAccountHistoryList(store.getStoreId(), orderColumn, orderType);
        return storeAccountLogs;
    }

    @Override
    public List<StoreCash> getCashHistoryList(Integer page, Integer pageSize, String orderColumn, String orderType) {
        PageHelper.startPage(page, pageSize);
        StoreMin store = WebUtil.getCurrentStore();
        List<StoreCash> storeCashes = storeCashMapper.getCashHistoryList(store.getStoreId(), orderColumn, orderType);
        return storeCashes;
    }

    @Override
    public StoreAccount getStoreAccount() {
        StoreMin store = WebUtil.getCurrentStore();
        return storeAccountMapper.getByStoreId(store.getStoreId());
    }

    @Override
    public int createStoreAccount(Integer storeId) {
        StoreAccount storeAccount = new StoreAccount();
        storeAccount.setStoreId(storeId);
        return storeAccountMapper.insertSelective(storeAccount);
    }

    @Override
    @Transactional
    public int storeDoCash(BigDecimal amount) throws OptionException, AlipayApiException {
        StoreMin currentStore = WebUtil.getCurrentStore();
        StoreAccount storeAccount = storeAccountMapper.getByStoreId(currentStore.getStoreId());

        //验证是否设置支付宝提现账户
        if (StringUtils.isEmpty(storeAccount.getAlipayAccount())) {
            throw new OptionException("未设置提现支付宝账户！");
        }

        //验证是否有足够的余额可以提现
        if (storeAccount.getAvailableBalance().compareTo(amount) < 0) {
            throw new OptionException("提现金额不足！");
        }

        StoreCash storeCash = new StoreCash();
        storeCash.setAmount(amount);
        storeCash.setCreateTime(new Date());
        storeCash.setStoreId(currentStore.getStoreId());
        storeCash.setOutBizNo(UUID.randomUUID().toString().replace("-",""));


        AlipayClient alipayClient = AliPay.getAlipayClient();
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();

        AlipayFundTransToaccountTransferModel model = new AlipayFundTransToaccountTransferModel();
        model.setAmount(amount.toString());
        model.setPayerShowName("商户提现");
        model.setPayeeAccount(storeAccount.getAlipayAccount());
        model.setOutBizNo(storeCash.getOutBizNo());
        /*
        收款方账户类型。可取值：
        1、ALIPAY_USERID：支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。
        2、ALIPAY_LOGONID：支付宝登录号，支持邮箱和手机号格式。*/
        model.setPayeeType("ALIPAY_LOGONID");

        request.setBizModel(model);

        AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
            storeAccount.setAvailableBalance(storeAccount.getAvailableBalance().subtract(amount));

            //记录提现记录
            storeCashMapper.insertSelective(storeCash);

            //记录账户流水记录
            StoreAccountLog storeAccountLog = new StoreAccountLog();
            storeAccountLog.setAmount(amount);
            storeAccountLog.setCreateTime(new Date());
            storeAccountLog.setStoreId(currentStore.getStoreId());
            storeAccountLog.setType(POJOConstants.STORE_ACCOUNT_LOG_ACASH);
            storeAccountLogMapper.insertSelective(storeAccountLog);
            return storeAccountMapper.updateByPrimaryKeySelective(storeAccount);
        } else {
            throw new OptionException("提现失败,原因："+response.getSubMsg());
        }

    }

    @Override
    public int settingStoreAlipay(String alipayAccount) {
        StoreMin currentStore = WebUtil.getCurrentStore();
        StoreAccount storeAccount = storeAccountMapper.getByStoreId(currentStore.getStoreId());
        storeAccount.setAlipayAccount(alipayAccount);
        return storeAccountMapper.updateByPrimaryKeySelective(storeAccount);
    }

    @Override
    public List<StoreAccountListDTO> getStoreAccountListDate(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        PageHelper.startPage(page,pageSize);
        List<StoreAccountListDTO> result = storeAccountMapper.getStoreAccountListDate(orderColumn,orderType,searchKey);
        return result;
    }

    @Override
    public List<StoreCashListDTO> getCashListDate(Integer page, Integer pageSize, String orderColumn, String orderType, String searchKey) {
        PageHelper.startPage(page,pageSize);
        List<StoreCashListDTO> result = storeCashMapper.getCashListDate(orderColumn,orderType,searchKey);
        return result;
    }

    @Override
    public int apisStoreDoCash(BigDecimal amount) throws OptionException, AlipayApiException{
        ApiSellerInfo sellerInfo = storeService.getSellerInfo();
        StoreAccount storeAccount = storeAccountMapper.getByStoreId(sellerInfo.getStoreId());

        //验证是否设置支付宝提现账户
        if (StringUtils.isEmpty(storeAccount.getAlipayAccount())) {
            throw new OptionException("未设置提现支付宝账户！");
        }

        //验证是否有足够的余额可以提现
        if (storeAccount.getAvailableBalance().compareTo(amount) < 0) {
            throw new OptionException("提现金额不足！");
        }

        StoreCash storeCash = new StoreCash();
        storeCash.setAmount(amount);
        storeCash.setCreateTime(new Date());
        storeCash.setStoreId(sellerInfo.getStoreId());
        storeCash.setOutBizNo(UUID.randomUUID().toString().replace("-",""));


        AlipayClient alipayClient = AliPay.getAlipayClient();
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();

        AlipayFundTransToaccountTransferModel model = new AlipayFundTransToaccountTransferModel();
        model.setAmount(amount.toString());
        model.setPayerShowName("商户提现");
        model.setPayeeAccount(storeAccount.getAlipayAccount());
        model.setOutBizNo(storeCash.getOutBizNo());
        /*
        收款方账户类型。可取值：
        1、ALIPAY_USERID：支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。
        2、ALIPAY_LOGONID：支付宝登录号，支持邮箱和手机号格式。*/
        model.setPayeeType("ALIPAY_LOGONID");

        request.setBizModel(model);

        AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
            storeAccount.setAvailableBalance(storeAccount.getAvailableBalance().subtract(amount));

            //记录提现记录
            storeCashMapper.insertSelective(storeCash);

            //记录账户流水记录
            StoreAccountLog storeAccountLog = new StoreAccountLog();
            storeAccountLog.setAmount(amount);
            storeAccountLog.setCreateTime(new Date());
            storeAccountLog.setStoreId(sellerInfo.getStoreId());
            storeAccountLog.setType(POJOConstants.STORE_ACCOUNT_LOG_ACASH);
            storeAccountLogMapper.insertSelective(storeAccountLog);
            return storeAccountMapper.updateByPrimaryKeySelective(storeAccount);
        } else {
            throw new OptionException("提现失败,原因："+response.getSubMsg());
        }
    }

    @Override
    public int apiSettingStoreAlipay(String alipayAccount) {
        ApiSellerInfo sellerInfo = storeService.getSellerInfo();
        StoreAccount storeAccount = storeAccountMapper.getByStoreId(sellerInfo.getStoreId());
        storeAccount.setAlipayAccount(alipayAccount);
        return storeAccountMapper.updateByPrimaryKeySelective(storeAccount);
    }

    @Override
    public String apiGetAlipayCashAccount() throws OptionException {
        ApiSellerInfo sellerInfo = storeService.getSellerInfo();

        if (sellerInfo == null){
            throw new OptionException("您没有绑定店铺获取没有成为商家");
        }

        StoreAccount storeAccount = storeAccountMapper.getByStoreId(sellerInfo.getStoreId());
        return storeAccount.getAlipayAccount();
    }
}
