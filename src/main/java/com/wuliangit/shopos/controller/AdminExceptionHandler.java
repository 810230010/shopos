package com.wuliangit.shopos.controller;

import com.wuliangit.shopos.common.controller.RestResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台管理界面异常捕获
 */
@ControllerAdvice(basePackages = "com.wuliangit.shopos.controller.admin")
public class AdminExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object errorHandlerOverJson(HttpServletRequest request, Exception exception) {
        RestResult result = new RestResult();
        exception.printStackTrace();
        result.setCode(500);
        result.setMsg(exception.getMessage());
        return result;
    }

}