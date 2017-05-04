package com.wuliangit.shopos.controller;

import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.model.StoreUser;
import com.wuliangit.shopos.service.StoreService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
        DateFormat defaultFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        CustomDateEditor defaultFormatEditor = new CustomDateEditor(defaultFormat, true);

        DateFormat dateFormatxxxx = new SimpleDateFormat("MMM d, YYYY");
        CustomDateEditor xxxxEditor = new CustomDateEditor(dateFormatxxxx, true);


        binder.registerCustomEditor(Date.class, defaultFormatEditor);
        binder.registerCustomEditor(Date.class, "xxxxx", xxxxEditor);
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