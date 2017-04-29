package com.wuliangit.shopos.controller;

import com.wuliangit.shopos.common.controller.RestResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * wab端异常捕获
 */
@RestControllerAdvice(basePackages = "com.wuliangit.shopos.controller.web")
public class WebGlobalHandler {

    @ExceptionHandler(value = Exception.class)
    public Object errorHandlerOverJson(HttpServletRequest request, Exception exception) {

        RestResult result = new RestResult();

        String servletPath = request.getServletPath();

        if (servletPath.startsWith("/admin")){
            return "admin/login";
        }

        result.setCode(500);
        result.setMsg(exception.getMessage());

        return result;
    }

}