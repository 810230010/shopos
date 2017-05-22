package com.wuliangit.shopos.common;

/**
 * 项目POJO公共枚举类
 * Created by nilme on 2017/2/21.
 */
public class POJOConstants {

    //用户类型
    //默认用户
    public final static String USER_TYPE_DEFAULT = "DEFAULT";
    //推客
    public final static String USER_TYPE_TUIKE = "TUIKE";
    //待审核推客
    public final static String USER_TYPE_PRE_TUIKE = "PRE_TUIKE";

    //认证
    //未认证
    public final static String NOT_AUTH = "NOT_AUTH";
    //已认证
    public final static String AUTHED = "AUTHED";
    //等待认证
    public final static String WAIT_AUTH = "WAIT_AUTH";
    //重新认证
    public final static String REAUTH = "REAUTH";


    //商品类型
    //活动商品
    public final static String GOODS_TYPE_ACTIVITY = "GOODS_TYPE_ACTIVITY";
    //普通商品
    public final static String GOODS_TYPE_NORMAL = "GOODS_TYPE_NORMAL";

    //支付方式
    //微信支付
    public final static String PAYWAY_WX = "PAYWAY_WX";
    //支付宝支付
    public final static String PAYWAY_ALIPAY = "PAYWAY_ALIPAY";
    //银行卡支付
    public final static String PAYWAY_CARD = "PAYWAY_CARD";

    //订单删除状态
    //未删除
    public final static String ORDER_DELETE_STATE_NO = "NO";
    //已删除
    public final static String ORDER_DELETE_STATE_YES = "YES";
    //永久删除
    public final static String ORDER_DELETE_STATE_FOREVER = "FOREVER";

    //订单评价状态
    //未评价
    public final static String ORDER_EVALUATION_STATE_NO = "NO";
    //已评价
    public final static String ORDER_EVALUATION_STATE_YES = "YES";

    //订单退款状态
    //无退款
    public final static String ORDER_REFUND_STATE_NO_REFUND = "NO_REFUND";
    //部分退款
    public final static String ORDER_REFUND_STATE_PART_REFUND = "PART_REFUND";
    //全部退款
    public final static String ORDER_REFUND_STATE_ALL_REFUND = "ALL_REFUND";

    //订单状态
    //已取消
    public final static String ORDER_STATE_CANCEL = "CANCEL";
    //默认(创建未付款)
    public final static String ORDER_STATE_INIT = "INIT";
    //已付款
    public final static String ORDER_STATE_PAYED = "PAYED";
    //已发货
    public final static String ORDER_STATE_DELIVE = "DELIVE";
    //已收货
    public final static String ORDER_STATE_RECEIVE = "RECEIVE";


    //品牌申请状态
    //申请中
    public final static String BRAND_STATE_APPLYING = "APPLYING";
    //未通过
    public final static String BRAND_STATE_NOTPASS = "NOTPASS";
    //申请通过
    public final static String BRAND_STATE_PASS = "PASS";

    //申请退换货类型
    //退款
    public final static String APPLY_REFUND_MOMEY = "REFUND_MOMEY";
    //换货
    public final static String APPLY_CHANGE_GOODS = "CHANGE_GOODS";
    //退款退货
    public final static String APPLY_REFUND_ALL = "REFUND_ALL";

    //订单支付方式
    //微信
    public final static String ORDER_PAYMENT_WX = "WX";
    //支付宝
    public final static String ORDER_PAYMENT_ALIPAY = "ALIPAY";
    //银联
    public final static String ORDER_PAYMENT_CARD = "CARD";

}
