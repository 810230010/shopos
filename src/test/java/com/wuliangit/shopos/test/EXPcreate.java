package com.wuliangit.shopos.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wuliangit.shopos.common.util.HttpUtils;
import com.wuliangit.shopos.dao.ExpressMapper;
import com.wuliangit.shopos.entity.Express;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nilme on 2017/5/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml", "classpath:spring-shiro.xml"})
@TransactionConfiguration(defaultRollback = false)
public class EXPcreate {


    @Autowired
    private ExpressMapper expressMapper;

    @Test
    public void run() {
        String host = "http://ali-deliver.showapi.com";
        String path = "/showapi_expressList";
        String method = "GET";
        String appcode = "926fa5517d054d0f8d21914cbd2c4fd4";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<>();
        querys.put("maxSize","1000");
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            String result = EntityUtils.toString(response.getEntity());

            System.out.println(result);

            JSONObject jsStr = JSONObject.parseObject(result);

            JSONObject xxx = jsStr.getJSONObject("showapi_res_body");
            JSONArray expressList = xxx.getJSONArray("expressList");

            for (Object o : expressList) {

                JSONObject obj = (JSONObject)o;

                Express express = new Express();
                express.setExpressCode(obj.getString("simpleName"));
                express.setExpressName(obj.getString("expName"));
                express.setLogo(obj.getString("imgUrl"));
                express.setPhone(obj.getString("phone"));
                express.setUrl(obj.getString("url"));

                expressMapper.insertSelective(express);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
