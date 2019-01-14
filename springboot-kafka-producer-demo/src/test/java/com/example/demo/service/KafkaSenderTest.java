package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by liulanhua on 2018/9/5.
 */
public class KafkaSenderTest extends BaseTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    String docId = UUID.randomUUID().toString().replaceAll("-","");

    @Autowired
    private KafkaSender sender;

    @Test
    public void send() throws Exception {
        String key = UUID.randomUUID().toString().replaceAll("-","");
        double price = Math.random()*100;
        int n = (int)price;

        for (int i = 0; i < 12; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",key);
            jsonObject.put("itemName","超威贝贝健无香电蚊液66");
            jsonObject.put("brand","品牌_"+ n);
            jsonObject.put("price",n);
            jsonObject.put("createTime",new Date());

            sender.send("",jsonObject.toJSONString());
            System.out.println(">>>>>>>>>>>>>>>>> key: "+ key);
        }
    }


    @Test
    public void sendMessage() throws Exception {
        String key = UUID.randomUUID().toString().replaceAll("-","");
        double price = Math.random()*100;
        int n = (int)price;

        for (int i = 0; i < 16; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",key);
            jsonObject.put("itemName","超威贝贝健无香电蚊液66");
            jsonObject.put("brand","品牌_"+ n);
            jsonObject.put("price",n);
            jsonObject.put("createTime",new Date());

            sender.sendMessage("",jsonObject.toJSONString());
            System.out.println(">>>>>>>>>>>>>>>>> key: "+ key);
        }
    }



    @Test
    public void test1() throws Exception {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        double price = Math.random()*100;
        int n = (int)price;

        JSONObject record = new JSONObject();
        record.put("id",id);
        record.put("itemName","超威贝贝健无香电蚊液66");
        record.put("brand","品牌_"+ n);
        record.put("price",n);
        record.put("createTime",new Date());

        JSONObject dataReq = new JSONObject();
        dataReq.put("docId",docId);
        dataReq.put("docType","doc1");
        dataReq.put("records", record);

        System.out.println("dataReq: " + dataReq.toJSONString());

        Map<String, Object> dataMap = recordValueToMap(dataReq.toJSONString());
        List<Map<String, Object>> dataList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dataMap)){
            dataList.add(dataMap);
        }

        System.out.println("dataList: " + dataList.size());


    }

    /**
     * 将record.value()转换成Map
     * @param value
     * @return
     */
    public static Map recordValueToMap(Object value){
        Map<String, Object> dataMap = new HashMap<>();
        if (value != null && value != ""){
            String valueStr = String.valueOf(value);
            dataMap = JSONObject.parseObject(valueStr, Map.class);
        }
        return dataMap;
    }

}