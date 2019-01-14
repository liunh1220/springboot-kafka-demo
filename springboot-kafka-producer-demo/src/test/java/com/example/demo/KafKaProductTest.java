package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.EsInsertReq;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;


public class KafKaProductTest {

    protected static final Logger logger = LoggerFactory.getLogger(KafKaProductTest.class);

    private static String kafkaServer = "192.168.126.124:9096";
    //private static String kafkaServer = "localhost:9092";
    private static String group = "liby_group";
    private static String topic = "search_center_topic_shop";
    //private static String topic = "test";

    public static void main(String[] args) throws Exception{
        sendMsgTest2();
         //provider();
    }



    private static void sendMsgTest2() throws IOException {
        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaServer);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384)  ;
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, Object> producer = new KafkaProducer<String, Object>(props);

        String docIndex = "big_data_center_shop_1546615849327";
        String docAlias = "big_data_center_shop_alias";
        String docType = "shop";
        boolean isFull = Boolean.FALSE;
        long batchNum = System.currentTimeMillis();
        int recordCount = 1;
        Map<String,Object> recordsMap = new HashMap<>();
        recordsMap.put("createTime", "2018-12-06 11:55:10");
        recordsMap.put("name", "立白洗衣粉");
        recordsMap.put("updateTime", "2019-31-04 14:31:09");
        recordsMap.put("id", "17aaa62d56364a22abc2256018f68411");
        recordsMap.put("desc", "立白洗衣粉店");
        for (int i = 0; i < 1; i++) {
            EsInsertReq insertReq = new EsInsertReq();
            insertReq.setBatchNum(batchNum);
            insertReq.setFull(isFull);
            insertReq.setRecordCount(recordCount);
            insertReq.setRecords(recordsMap);
            insertReq.setDocAlias(docAlias);
            insertReq.setDocIndex(docIndex);
            insertReq.setDocType(docType);
            producer.send(new ProducerRecord<String, Object>("search_center_topic_shop", JSON.toJSONString(insertReq)));
            System.out.println(">>>>>>>>>>>>>>>>> insertReq: " + JSON.toJSONString(insertReq));
        }

        producer.close();
    }


    private static void provider(){
        try {
            Properties props = new Properties();
            props.put("bootstrap.servers", kafkaServer);
            props.put("acks", "all");
            props.put("retries", 0);
            props.put("batch.size", 16384)  ;
            props.put("linger.ms", 1);
            props.put("buffer.memory", 33554432);
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

            String docId = UUID.randomUUID().toString().replaceAll("-","");

            Producer<String, Object> producer = new KafkaProducer<String, Object>(props);
            for (int i = 0; i < 1; i++) {
                String id = UUID.randomUUID().toString().replaceAll("-","");
                double price = Math.random()*100;
                int n = (int)price;

                JSONObject data = new JSONObject();
                data.put("id",id);
                data.put("itemName","超威贝贝健无香电蚊液66");
                data.put("brand","品牌_"+ n);
                data.put("price",n);
                data.put("createTime",new Date());

                JSONObject dataReq = new JSONObject();
                dataReq.put("docId",docId);
                dataReq.put("records", data);

                producer.send(new ProducerRecord<String, Object>(topic, dataReq.toJSONString()));

                System.out.println(">>>>>>>>>>>>>>>>> id: "+ id);
            }
            producer.close();
        }catch (Exception e){
            logger.error("",e);
        }

    }




}
