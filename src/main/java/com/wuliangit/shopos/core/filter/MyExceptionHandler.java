/**
 * Olymtech.com Inc.
 * Copyright (c) 2002-2015 All Rights Reserved
 */
package com.wuliangit.shopos.core.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuliangit.shopos.core.controller.RestResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taoshanchang 15/11/20
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

    protected Log log = LogFactory.getLog(this.getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String, Object> model = new HashMap<String, Object>();

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            log.error(ex.getMessage());
            log.error(ex.getStackTrace());

            ex.printStackTrace();

            if (method.getMethod().getReturnType().getTypeName().equals("java.lang.String")){
                //根据不同错误转向不同页面
                return new ModelAndView("error", model);
            }else{
                PrintWriter writer = null;
                try {
                    writer = response.getWriter();

                    RestResult res = new RestResult();
                    res.setCode(RestResult.ERROR_CODE);
                    res.setMsg(ex.getMessage());

                    ObjectMapper mapper = new ObjectMapper();
                    String json = mapper.writeValueAsString(res);
                    writer.write(json);

                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    writer.close();
                }finally {
                    writer.close();
                }
                return null;
            }
        }
        return new ModelAndView("error", model);
    }

}