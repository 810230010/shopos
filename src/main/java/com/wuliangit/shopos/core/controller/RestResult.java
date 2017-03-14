package com.wuliangit.shopos.core.controller;

import java.util.HashMap;

/**
 * Created by taoshanchang on 16/8/2.
 */
public class RestResult extends HashMap<String, Object> {

    public final String CODE_KEY = "code";
    public final String MSG_KEY = "msg";
    public final String DATA_KEY = "data";

    public final static int SUCCESS_CODE = 200;
    public final static int ERROR_CODE = 500;

    public final static String SUCCESS_MSG = "success";
    public final static String ERROR_MSG = "error";

    private HashMap<String, Object> data = null;

    public RestResult() {
        this.put(CODE_KEY, SUCCESS_CODE);
        this.put(MSG_KEY, SUCCESS_MSG);
    }

    public RestResult add(String key, Object value) {
        if (data == null){
            this.data = new HashMap<String, Object>();
            this.put(DATA_KEY, this.data);
        }

        this.data.put(key, value);
        return this;
    }

    public void setCode(int code) {
        this.put(CODE_KEY, code);
    }

    public void setMsg(String msg) {
        this.put(MSG_KEY, msg);
    }


    public final static String KEY_USER = "user";

    public final static String COOKIE = "cookie";


}
