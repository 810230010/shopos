package com.wuliangit.shopos.common.shiro.filter;

import com.google.gson.Gson;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.shiro.token.TokenManager;
import com.wuliangit.shopos.entity.Member;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.*;

import static com.wuliangit.shopos.common.CoreConstants.SESSION_CURRENT_USERID;

/**
 * Created by taoshanchang on 16/8/1.
 */
public class ApiFilter extends AccessControlFilter {

    static final String SIGN = "sign";
    static final String TIMESTAMP = "timestamp";
    static final String USERID = "userId";

    private TokenManager<Integer, Member> tokenManager;



    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        String sign = request.getParameter(SIGN);
        String timestamp = request.getParameter(TIMESTAMP);
        String userIdStr = request.getParameter(USERID);

        //判断必须参数是否为空
        if (sign == null || timestamp == null || userIdStr == null) {
            return false;
        }

        Integer userId = Integer.parseInt(userIdStr);

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SESSION_CURRENT_USERID,userId);

        // 判断用户是否已经登录
        String serverToken = tokenManager.getToken(userId);

        if(serverToken == null){
            return false;
        }

        //获取参数
        Enumeration<String> enumeration = request.getParameterNames();
        Map map = new HashMap();
        while (enumeration.hasMoreElements()) {
            String paramName = (String) enumeration.nextElement();

            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }

        map.put("token", serverToken);

        String sortParam = this.sortParameter(map);

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String requestURI = httpServletRequest.getRequestURI();

        String perSingUrl = requestURI + sortParam;

        // 生成一个MD5加密计算摘要
        String signUrl = new Md5Hash(perSingUrl).toString();

//        if (signUrl.equals(sign)) {
//            return true;
//        } else {
//            return false;
//        }

        //调试的时候不进行鉴权
        return true;

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        RestResult result = new RestResult();

        String sign = request.getParameter(SIGN);
        String timestamp = request.getParameter(TIMESTAMP);
        String userId = request.getParameter(USERID);

        // 判断用户是否已经登录
        String serverToken = tokenManager.getToken(Integer.parseInt(userId));

        if (sign == null || timestamp == null || userId == null) {
            result.setCode(403);
            result.setMsg("parameter of \'sign\' and \'timestamp\' and \'userId\' could not be null, please check it again!");
        }else{
            result.setCode(402);
            result.setMsg("unauthentication request! pelease login before request the api");
        }

        if(serverToken == null){//未登录
            result.setCode(401);
            result.setMsg("please login first!!!");
        }

        Gson gson = new Gson();
        PrintWriter writer = httpResponse.getWriter();
        writer.write(gson.toJson(result));
        writer.flush();
        return false;
    }

    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    /**
     * 对参数字典序排序，并拼接成url参数
     * @param maptest
     * @return
     */
    private String sortParameter(Map maptest) {
        Collection<String> keyset = maptest.keySet();
        List<String> list = new ArrayList<String>(keyset);

        //对key键值按字典升序排序
        Collections.sort(list);

        StringBuilder bs = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {

            if (!list.get(i).equals(SIGN)) {
                if (flag == 0) {
                    bs.append("?" + list.get(i)).append("=").append(maptest.get(list.get(i)));
                    flag = 1;
                } else {
                    bs.append("&").append(list.get(i)).append("=").append(maptest.get(list.get(i)));
                }
            }
        }
        return bs.toString();
    }
}
