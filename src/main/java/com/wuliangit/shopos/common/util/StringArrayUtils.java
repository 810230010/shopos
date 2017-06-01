package com.wuliangit.shopos.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author boom
 * @description 传递数组时对于数组的处理
 * @create 2017-06-01 22:16
 **/
public class StringArrayUtils {
    public static List<String> dissloveQuotation(List<String> param){
        List<String> list = new ArrayList<String>();
        for(int i=0;i<param.size();i++){
            if(i == 0){
                list.add(param.get(i).substring(2,param.get(i).length()-1));
            }else if(i == param.size()-1){
                list.add(param.get(i).substring(1,param.get(i).length()-2));
            }else{
                list.add(param.get(i).substring(1,param.get(i).length()-1));
            }
        }
        return list;
    }
}
