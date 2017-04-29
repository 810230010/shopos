package com.wuliangit.shopos.controller;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.StoreService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台管理界面异常捕获
 */
@ControllerAdvice(basePackages = "com.wuliangit.shopos.controller.store")
public class StoreGlobalHandler {

    @Autowired
    private StoreService storeService;

    @ModelAttribute("storeUser")
    public StoreUser newUser() {
        StoreUser storeUser = WebUtil.getCurrentStore();
        return storeUser;
    }


    @ExceptionHandler(value = ResourceNotFoundException.class)
    public String errorHandlerOverJson(HttpServletRequest request, ResourceNotFoundException exception) {
        return "500";
    }

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