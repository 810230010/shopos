package com.wuliangit.shopos.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class ObjectMappingCustomer extends ObjectMapper
    {  
      
        public ObjectMappingCustomer()  
        {  
            super();  
            // 允许单引号
            this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);

            //时间处理,不加是时间戳
            this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

            // 空值处理为空串
            SerializerProvider sp = this.getSerializerProvider();
            sp.setNullValueSerializer(new JsonSerializer<Object>(){

                @Override
                public void serialize(Object value, JsonGenerator jg, SerializerProvider sp) throws IOException {
                     jg.writeString("");  
                }
            });
        }
    }