package com.wuliangit.shopos.controller;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.exception.OptionException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 移动端接口异常捕获
 */
@RestControllerAdvice(basePackages = "com.wuliangit.shopos.controller.api")
public class ApiGlobalHandler {

    private static Log logger = LogFactory.getLog(ApiGlobalHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Object errorHandlerOverJson(HttpServletRequest request, Exception exception) {
        RestResult result = new RestResult();
        result.setMsg(exception.getMessage());
        result.setCode(500);
        if (!(exception instanceof OptionException)){
            Map<String, String[]> parameterMap = request.getParameterMap();

            StringBuilder sb = new StringBuilder();

            sb.append("参数：\n");

            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                sb.append("Key = " + entry.getKey() + ", Value = " + entry.getValue()[0]+"\n");
            }

            logger.error(sb.toString(),exception);
            exception.printStackTrace();
        }
        return result;
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public Object methodArgumentTypeMismatchException(HttpServletRequest request, Exception exception) {
        logger.error("",exception);
        RestResult result = new RestResult();
        result.setCode(500);
        exception.printStackTrace();
        result.setMsg("参数不匹配");
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
        logger.error("",ex);
        result.setCode(HttpStatus.METHOD_NOT_ALLOWED.value());
        result.setMsg(ex.getMessage());
        ex.printStackTrace();
        return result;
    }

    /**
     * 处理Http method使用不正确的错误, 例如: 新增产品应该使用POST, 但实际使用了GET
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleBeanPropertyBindingResult(HttpServletRequest req, BindException ex) {
        RestResult result = new RestResult();
        logger.error("",ex);
        result.setCode(HttpStatus.BAD_REQUEST.value());
        result.setMsg(ex.getMessage());
        ex.printStackTrace();
        return result;
    }




}