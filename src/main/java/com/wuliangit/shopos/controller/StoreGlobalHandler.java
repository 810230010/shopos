package com.wuliangit.shopos.controller;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.MenuDTO;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.exception.OptionException;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.MailService;
import com.wuliangit.shopos.service.StoreService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 后台管理界面全局前置设置
 */
@ControllerAdvice(basePackages = "com.wuliangit.shopos.controller.store")
public class StoreGlobalHandler {

    private static Log logger = LogFactory.getLog(StoreGlobalHandler.class);

    @Autowired
    private StoreService storeService;

    @Autowired
    private MailService mailService;

    @ModelAttribute("storeUser")
    public StoreMin newUser() {
        StoreMin storeMin = WebUtil.getCurrentStore();
        return storeMin;
    }

    @ModelAttribute("menus")
    public List<MenuDTO> setMenus() {
        List<MenuDTO> menus = (List<MenuDTO>)WebUtil.getSession().getAttribute(CoreConstants.SESSION_CURRENT_MENU);
        return menus;
    }

    /**
     * @Description: 获取未读消息条数
     * @Author: pangweichao
     * @Date: 11:30 2017/6/3
     * @Param: []
     * @return: int
     */
    @ModelAttribute("mailCount")
    public int setMailCount() {
        Integer result = 0;
        Seller seller = WebUtil.getCurrentSeller();
        if(seller != null) result = mailService.getMessageCount(seller.getStoreId());
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat defaultFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        CustomDateEditor defaultFormatEditor = new CustomDateEditor(defaultFormat, true);

        DateFormat dateFormatxxxx = new SimpleDateFormat("MMM d, YYYY");
        CustomDateEditor xxxxEditor = new CustomDateEditor(dateFormatxxxx, true);


        binder.registerCustomEditor(Date.class, defaultFormatEditor);
        binder.registerCustomEditor(Date.class, "xxxxx", xxxxEditor);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public String errorHandlerOverJson(HttpServletRequest request, ResourceNotFoundException exception) {
        logger.error("",exception);
        return "500";
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String errorHandlerOverJson(HttpServletRequest request, Exception exception) {
        if (!(exception instanceof OptionException)){
            logger.error("",exception);
            exception.printStackTrace();
        }
        return "500";
    }

}