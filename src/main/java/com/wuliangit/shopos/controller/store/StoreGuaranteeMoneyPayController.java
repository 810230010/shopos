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
     *
     * @return
     */
    @RequestMapping("")
    @ResponseBody
    public void alipayGuaranteePrepare(HttpServletResponse response) {

        //生成保证金订单
        GuaranteeOrder order = new GuaranteeOrder();
        order.setOutTradeNo(OrderUtil.makeOrderId());
        Integer storeId = WebUtil.getCurrentStore().getStoreId();
        order.setStoreId(storeId);
        order.setOrderStatus(POJOConstants.ORDER_STATE_INIT);
        order.setCreateTime(new Date());
        order.setOutTradeNo(OrderUtil.makeOrderId());
        guaranteeService.createGuaranteeOrder(order);

        AlipayClient client = AliPay.getAlipayClient();
        //初始化支付宝支付页面请求
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

        //传给支付宝的支付参数对象
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        //支付的金额
        BigDecimal payprice = new BigDecimal(0.01);

        model.setOutTradeNo(order.getOutTradeNo());
        model.setTotalAmount(payprice.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        model.setBody("保证金缴纳订单");
        model.setPassbackParams("single");
        model.setSubject("缴纳金支付");
        model.setTimeoutExpress("30m");
        model.setProductCode(AliPay.PRODUCTCODE_INSTANT);

        request.setBizModel(model);
        request.setNotifyUrl(notifyUrl);
        request.setReturnUrl("http://shopos.wuliangit.com/store/setting/payGuaranteeMoneyPage");

        try {
            AlipayTradePagePayResponse alipayTradePagePayResponse = client.pageExecute(request);

            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "text/html;charset=UTF-8");
            out.println(alipayTradePagePayResponse.getBody());
            out.flush();
            out.close();

            logger.debug("payInfo----->" + alipayTradePagePayResponse.getBody());
            System.out.println(alipayTradePagePayResponse.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 保证金缴纳支付宝异步通知
     *
     * @param request
     * @param response
     * @throws AlipayApiException
     * @throws IOException
     */
    @RequestMapping("/notify")
    public void alipayNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        //获取支付宝POST过来反馈信息
        if (logger.isDebugEnabled()) {
            logger.debug("支付宝异步通知");
        }
        System.out.println("支付宝异步通知");

        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //支付宝异步通知验证
        boolean flag = false;
        try {
             flag = AlipaySignature.rsaCheckV1(params, AliPay.getAlipayPublicKey(), AlipayConstants.CHARSET_UTF8, AlipayConstants.SIGN_TYPE_RSA2);
        }catch (Exception e){
            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "text/html;charset=UTF-8");
            out.println("非法请求");
            out.flush();
            out.close();
            return ;
        }
        //验证通过，处理业务逻辑
        if (flag) {
            String tradeStatus = params.get("trade_status");
            if (tradeStatus != null && tradeStatus.endsWith("TRADE_SUCCESS")) {
                String tradeNo = params.get("trade_no");
                String outTradeNo = params.get("out_trade_no");

                GuaranteeOrder order = guaranteeService.getGuaranteeOrderByOutTradeNo(outTradeNo);

                if (order == null){
                    PrintWriter out = response.getWriter();
                    out.println("failure");
                    out.flush();
                    out.close();
                    return ;
                }

                order.setTradeNo(tradeNo);

                order.setOrderStatus(POJOConstants.ORDER_STATE_PAYED);
                order.setPayTime(new Date());
                guaranteeService.updateGuaranteeOrder(order);

                PrintWriter out = response.getWriter();
                out.println("success"); // 请不要修改或删除
                out.flush();
                out.close();
                return ;
            } else {
                logger.error("非法请求！");
            }
        }
    }
}