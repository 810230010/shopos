package com.wuliangit.shopos.controller.api;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.dto.ApiOrderCreateDTO;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.exception.OrderException;
import com.wuliangit.shopos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

/**
 * 支付相关
 * Created by nilme on 2017/5/3.
 */

@Controller
@RequestMapping(value = "/api/v1/order")
public class MPayController {

    private String notifyUrl = "http://shop.wuliangit.com/api/v1/pay/alipay/notify";

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public Object createOrder(ApiOrderCreateDTO orderInfo) throws OrderException {
        RestResult result = new RestResult();
        List<Order> orders = orderService.ApiCreateOrder(orderInfo);

        List<Integer> orderIds = new ArrayList<>();

        //设置订单价格
        //商品总价
        BigDecimal goodsAmount = new BigDecimal(0);
        //邮费总价
        BigDecimal carriage = new BigDecimal(0);
        String carriageInfo = "";

        int flag = 0;
        for (Order order : orders) {
            carriage.add(order.getCarriage());
            goodsAmount.add(order.getGoodsAmount());
            if (flag == 0 ){
                carriageInfo += order.getCarriage().toString();
                flag= 1;
            }else{
                carriageInfo += "+"+order.getCarriage().toString();
            }
            orderIds.add(order.getOrderId());
        }

        result.add("goodsAmount",goodsAmount);
        result.add("orderAmount",goodsAmount.add(carriage));
        result.add("carriageInfo",carriageInfo);
        result.add("orderIds",orderIds);

        //////////////
//        AlipayClient alipayClient = AliPay.getAlipayClient();
//        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//
//        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
//
//        request.setBizModel(model);
//        request.setNotifyUrl(notifyUrl);
//        try {
//            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
//            result.add("payInfo", response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
//            System.out.println(response.getBody());
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }

        //////////////
        return result;
    }


    /**
     * 准备付款
     *
     * @return
     */
    @RequestMapping(value = "/order/prepare1", method = RequestMethod.POST)
    @ResponseBody
    public Object preparePay2() {
        RestResult result = new RestResult();

        AlipayClient alipayClient = AliPay.getAlipayClient();

        AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();

        // 封装请求支付信息
        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        model.setBody("我是测试数据");
        model.setSubject("App支付测试Java");
        model.setOutTradeNo("10101010");
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAYq");
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl("http://shop.wuliangit.com/api/v1/pay/alipay/notify");
        // 设置同步地址
        alipay_request.setReturnUrl("http://shop.wuliangit.com/store");

        // form表单生产
        String form = "";
        try {
            // 调用SDK生成表单
            AlipayTradeWapPayResponse alipayTradeWapPayResponse = alipayClient.pageExecute(alipay_request);

            String body = alipayTradeWapPayResponse.getBody();

            System.out.println(body);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("/alipay/notify")
    public void alipayNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
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
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean flag = AlipaySignature.rsaCheckV1(params, AliPay.getAlipayPublicKey(), AlipayConstants.CHARSET_UTF8, AlipayConstants.SIGN_TYPE_RSA2);

        System.out.println("zhifubao xxxxxxx");

        PrintWriter out = response.getWriter();
        out.println("success"); // 请不要修改或删除
        out.flush();

    }



}
