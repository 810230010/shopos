package com.wuliangit.shopos.common.exp;

import com.wuliangit.shopos.common.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nilme on 2017/5/17.
 */
public class ExpUtil {


    public static String doQuery(String com, String nu) {
        String host = "https://ali-deliver.showapi.com";
        String path = "/showapi_expInfo";
        String method = "GET";
        String appcode = "926fa5517d054d0f8d21914cbd2c4fd4";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<>();
        querys.put("com", com);
        querys.put("nu", nu);
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);

            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
