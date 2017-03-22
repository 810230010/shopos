package com.wuliangit.shopos.core.controller;

import java.util.HashMap;

/**
 * restful接口风格返回数据结构对象
 * Created by taoshanchang on 16/8/2.
 */
public class RestResult extends HashMap<String, Object> {

    public final String KEY_CODE = "code";
    public final String KEY_MSG = "msg";
    public final String KEY_DATA = "data";

    //请求成功
    public final static int CODE_SUCCESS = 200;
    //业务错误
    public final static int CODE_BUSINESS_ERROR = 201;
    //服务器错误，确认状态并报告问题
    public final static int CODE_SERVERERROR = 500;

    public final static String MSG_SUCCESS = "OK";
    public final static String MSG_ERROR = "Internal Server Error";

    private HashMap<String, Object> data = null;

    public RestResult() {
        this.put(KEY_CODE, CODE_SUCCESS);
        this.put(KEY_MSG, MSG_SUCCESS);
    }

    public RestResult(String msg, int code) {
        this.put(KEY_CODE, code);
        this.put(KEY_MSG, msg);
    }

    public RestResult add(String key, Object value) {
        if (data == null) {
            this.data = new HashMap<String, Object>();
            this.put(KEY_DATA, this.data);
        }

        this.data.put(key, value);
        return this;
    }

    public void setCode(int code) {
        this.put(KEY_CODE, code);
    }

    public void setMsg(String msg) {
        this.put(KEY_MSG, msg);
    }


}
