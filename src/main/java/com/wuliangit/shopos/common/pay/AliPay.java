package com.wuliangit.shopos.common.pay;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.wuliangit.shopos.common.util.SpringUtils;
import com.wuliangit.shopos.service.SettingService;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nilme on 2017/5/4.
 */
public class AliPay {
    private static AlipayClient client;
    private static ReentrantLock lock = new ReentrantLock();

    public static final String ALIPAY_APP_ID = "ALIPAY_APP_ID";
    public static final String ALIPAY_PUBLIC_KEY = "ALIPAY_PUBLIC_KEY";
    public static final String ALIPAY_APP_PRIVATE_KEY = "ALIPAY_APP_PRIVATE_KEY";
    public static final String ALIPAY_CHECK = "ALIPAY_CHECK";

    //销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
    public static final String PRODUCTCODE_MSECURITY = "QUICK_MSECURITY_PAY";

    public static final String PRODUCTCODE_INSTANT = "FAST_INSTANT_TRADE_PAY";

    private static String serviceUrl = "https://openapi.alipay.com/gateway.do";

    private static String alipayPublicKey = null;
    private static String appId = null;
    private static String appPrivateKey = null;

    public static AlipayClient getAlipayClient() {
        if (client == null) {
            lock.lock();
            if (client == null) {
                SettingService settingService = SpringUtils.getBean(SettingService.class);
                appId = settingService.getSetting(ALIPAY_APP_ID);
                alipayPublicKey = settingService.getSetting(ALIPAY_PUBLIC_KEY);
                appPrivateKey = settingService.getSetting(ALIPAY_APP_PRIVATE_KEY);

                client = new DefaultAlipayClient(serviceUrl,
                        appId, appPrivateKey, AlipayConstants.FORMAT_JSON,
                        AlipayConstants.CHARSET_UTF8, alipayPublicKey, AlipayConstants.SIGN_TYPE_RSA2);
            }
            lock.unlock();
        }
        return client;
    }

    /**
     * 更新支付宝配置
     *
     * @return
     */
    public static AlipayClient updateAlipayClient() {
        client = null;
        return AliPay.getAlipayClient();
    }

    /**
     * 获取支付宝公钥
     * @return
     */
    public static String getAlipayPublicKey() {
        SettingService settingService = SpringUtils.getBean(SettingService.class);
        if (StringUtils.isEmpty(alipayPublicKey)){
            alipayPublicKey = settingService.getSetting(ALIPAY_PUBLIC_KEY);
        }
        return alipayPublicKey;
    }

}
