package com.wuliangit.shopos.controller;

import com.wuliangit.shopos.core.controller.RestResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 移动端接口异常捕获
 */
@RestControllerAdvice(basePackages = "com.wuliangit.shopos.controller.api")
public class RestExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object errorHandlerOverJson(HttpServletRequest request, Exception exception) {
        RestResult result = new RestResult();
        result.setCode(500);
        result.setMsg(exception.getMessage());
        return result;
    }

}