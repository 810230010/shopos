package com.wuliangit.shopos.test;

import com.alibaba.druid.filter.config.ConfigTools;
import com.google.gson.Gson;
import com.wuliangit.shopos.model.OrderGoodsNum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nilme on 2017/5/6.
 */
public class Test {

    public static void main(String[] args) {

        Map<Integer,OrderGoodsNum> orderInfo = new HashMap<>();

        OrderGoodsNum info = new OrderGoodsNum(35,2,1);


        Gson gson = new Gson();

        String s = gson.toJson(orderInfo);

        System.out.println(s);


    }

    public static void main2(String[] args) throws Exception {
        //密码明文
        String password = "";
        System.out.println("密码[ "+password+" ]的加密信息如下：\n");
        String [] keyPair = ConfigTools.genKeyPair(512);
        //私钥
        String privateKey = keyPair[0];
        //公钥
        String publicKey = keyPair[1];
        //用私钥加密后的密文
        String password2 = ConfigTools.encrypt(privateKey, password);
        System.out.println("privateKey:"+privateKey);
        System.out.println("publicKey:"+publicKey);
        System.out.println("password:"+password2);

        String decrypt = ConfigTools.decrypt(publicKey,password2);
        System.out.println(decrypt);
    }
}
