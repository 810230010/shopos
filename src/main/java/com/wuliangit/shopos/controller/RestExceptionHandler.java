package com.wuliangit.shopos.controller;

import com.wuliangit.shopos.common.controller.RestResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
        exception.printStackTrace();
        result.setMsg(exception.getMessage());
        return result;
    }


    /**
     * 处理Http method使用不正确的错误, 例如: 新增产品应该使用POST, 但实际使用了GET
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Object handleHttp405Exception(HttpServletRequest req, HttpRequestMethodNotSupportedException ex) {
        RestResult result = new RestResult();
        result.setCode(HttpStatus.METHOD_NOT_ALLOWED.value());
        result.setMsg(ex.getMessage());
        return result;

    }



}