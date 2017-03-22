package com.wuliangit.shopos.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台管理界面异常捕获
 */
@ControllerAdvice(basePackages = "com.wuliangit.shopos.controller.admin")
public class AdminExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object errorHandlerOverJson(HttpServletRequest request, Exception exception) {
        return "admin/login";
    }

}