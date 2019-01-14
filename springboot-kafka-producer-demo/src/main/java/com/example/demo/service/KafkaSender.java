package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.KafkaGlobals;
import com.example.demo.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Kafka生产者
 * Created by liulanhua on 2018/9/4.
 */
@Component
public class KafkaSender {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaGlobals globals;
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 发送消息方法
     */
    public void send(String topic, String msg) {
        logger.info("KafkaSender发送消息,消息内容 : {}", msg);
        try {
            if (StringUtils.isEmpty(topic))
                topic = globals.getTopic();
            String uuid = UUID.randomUUID().toString();

            Message message = new Message();
            message.setId(uuid);
            message.setMsg(msg);
            message.setSendTime(new Date());

            kafkaTemplate.send(topic, uuid, msg);
            //kafkaTemplate.send(topic, uuid, JSONObject.toJSONString(message));

        }catch (Exception e){
            logger.error("KafkaSender发送消息异常",e);
        }
        logger.info("KafkaSender发送消息完成");
    }

    /**
     * 发送消息方法
     */
    public void sendMessage(String topic, String msg) {
        logger.info("KafkaSender发送消息,消息内容 : {}", msg);
        try {
            if (StringUtils.isEmpty(topic))
                topic = globals.getTopic();
            String key = UUID.randomUUID().toString().replaceAll("-","");

            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, msg);

            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onSuccess(SendResult<String, String> result) {
                    logger.info("发送消息成功！,key:{}", result.getProducerRecord().key());
                }
                @Override
                public void onFailure(Throwable ex) {
                    logger.warn("发送消息失败！！！,Message:{}", ex.getMessage());
                }
            });
        }catch (Exception e){
            logger.error("KafkaSender发送消息异常",e);
        }
        logger.info("KafkaSender发送消息完成");
    }

}
