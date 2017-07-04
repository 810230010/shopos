package com.wuliangit.shopos.controller.store;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.common.util.OrderUtil;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.entity.GuaranteeOrder;
import com.wuliangit.shopos.service.GuaranteeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Administrator on 2017/7/4.
 */
@Controller
@RequestMapping("/store/guarantee/pay")
public class StoreGuaranteeMoneyPayController {
    @Autowired
    private GuaranteeService guaranteeService;
    private static Log logger = LogFactory.getLog(StoreGuaranteeMoneyPayController.class);
    //支付宝回调结果地址
    private String notifyUrl = "http://shopos.wuliangit.com/store/guarantee/pay/notify";


    /**
     * 创建支付保证金的订单
     * @return
     */
    @RequestMapping("/generateOrder")
    @ResponseBody
    public Object guaranteeOrderGenerate() {
        RestResult result = null;
        GuaranteeOrder order = new GuaranteeOrder();
        order.setOutTradeNo(OrderUtil.makeOrderId());
        Integer storeId = WebUtil.getCurrentStore().getStoreId();
        order.setStoreId(storeId);
        order.setOrderStatus(POJOConstants.ORDER_STATE_INIT);
        order.setCreateTime(new Date());
        if(guaranteeService.insertGuaranteeOrder(order) != 1){
            result = new RestResult("未知错误, 创建订单失败", 405);
        }else{
            GuaranteeOrder orderInfo = guaranteeService.getGuaranteeOrderByOutTradeNo(order.getOutTradeNo());
            result = new RestResult();
            result.add("orderId", orderInfo.getOrderId());
        }
        return result;
    }

    @RequestMapping("/prepare")
    @ResponseBody
    public Object alipayGuaranteePrepare(Integer orderId) {
        RestResult result = new RestResult();
        AlipayClient client = AliPay.getAlipayClient();
        //初始化支付宝支付页面请求
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

        //传给支付宝的支付参数对象
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        //支付的金额
        BigDecimal payprice = new BigDecimal(0.01);

        GuaranteeOrder order = guaranteeService.getGuaranteeOrderByOrderID(orderId);
        model.setOutTradeNo(order.getOutTradeNo());
        model.setTotalAmount(payprice.setScale(2,   BigDecimal.ROUND_HALF_UP).toString());
        model.setBody("保证金缴纳订单");
        model.setPassbackParams("single");
        model.setSubject("缴纳金支付");
        model.setTimeoutExpress("30m");

        request.setBizModel(model);
        request.setNotifyUrl(notifyUrl);

        try {
            AlipayTradePagePayResponse response = client.pageExecute(request);
            result.add("payInfo", response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
            logger.debug("payInfo----->"+ response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/notify")
    public void alipayNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        //获取支付宝POST过来反馈信息
        if (logger.isDebugEnabled()) {
            logger.debug("支付宝异步通知");
        }

        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //支付宝异步通知验证
        boolean flag = AlipaySignature.rsaCheckV1(params, AliPay.getAlipayPublicKey(), AlipayConstants.CHARSET_UTF8, AlipayConstants.SIGN_TYPE_RSA2);

        //验证通过，处理业务逻辑
        if (flag) {
            String tradeStatus = params.get("trade_status");
            if (tradeStatus != null && tradeStatus.endsWith("TRADE_SUCCESS")) {
                String tradeNo = params.get("trade_no");
                String outTradeNo = params.get("out_trade_no");
                String passbackParams = params.get("passback_params");

                GuaranteeOrder order = guaranteeService.getGuaranteeOrderByOutTradeNo(outTradeNo);
                order.setTradeNo(tradeNo);
                orderPayed(order);


            } else {
                logger.error("非法请求！");
            }

            PrintWriter out = response.getWriter();
            out.println("success"); // 请不要修改或删除
            out.flush();
        }
    }

    /**
     * 成功支付订单状态修改
     * @param order
     */
    private void orderPayed(GuaranteeOrder order){
        order.setOrderStatus(POJOConstants.ORDER_STATE_PAYED);
        order.setPayTime(new Date());
        guaranteeService.updateGuaranteeOrder(order);
    }
}