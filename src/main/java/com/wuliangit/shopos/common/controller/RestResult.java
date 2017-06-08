package com.wuliangit.shopos.common.controller;

import java.util.HashMap;

/**
 * restful接口风格返回数据结构对象
 * Created by taoshanchang on 16/8/2.
 */
public class RestResult{
    //请求成功
    public final static int CODE_SUCCESS = 200;
    //业务错误
    public final static int CODE_BUSINESS_ERROR = 201;
    //服务器错误，确认状态并报告问题
    public final static int CODE_SERVERERROR = 500;

    public final static String MSG_SUCCESS = "OK";
    public final static String MSG_ERROR = "Internal Server Error";

    private HashMap<String, Object> data = null;
    private String msg = MSG_SUCCESS;
    private int code = 200;

    public RestResult() {
        this.setCode(CODE_SUCCESS);
        this.setMsg(MSG_SUCCESS);
    }

    public RestResult(String msg, int code) {
        this.setCode(code);
        this.setMsg(msg);
    }

    public RestResult add(String key, Object value) {
        if (data == null) {
            this.data = new HashMap<String, Object>();
        }
        this.data.put(key, value);
        return this;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
