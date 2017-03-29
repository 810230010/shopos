package com.wuliangit.shopos.common.filter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by nilme on 2017/2/28.
 */
public class SysInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();

//        String pmenuId = request.getParameter("pmenuId");
//        String menuId = request.getParameter("menuId");

//        List<MenuDTO> menus = (List<MenuDTO>) SecurityUtils.getSubject().getSession().getAttribute(Constants.SESSION_CURRENT_MENU);
//
//        if (modelAndView != null){
//            modelAndView.addObject("pmenuId",pmenuId);
//            modelAndView.addObject("menuId",menuId);
//            modelAndView.addObject("menus",menus);
//            Object u = SecurityUtils.getSubject().getSession().getAttribute(Constants.SESSION_CURRENT_USER);
//            if (u instanceof Zhulituan){
//                modelAndView.addObject("userType","zlt");
//            }else if(u instanceof SysUser){
//                modelAndView.addObject("userType","admin");
//            }
//            modelAndView.addObject("user",u);
//        }

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8100");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Credentials","true");
    }

}
