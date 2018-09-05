package com.example.demo.service;

import com.example.demo.config.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Kafka生产者
 * Created by liulanhua on 2018/9/4.
 */
@Component
public class KafkaSender {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Globals globals;
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 发送消息方法
     */
    public void send(String msg) {
        logger.info("KafkaSender发送消息,消息内容 : {}", msg);
        try {
            String uuid = UUID.randomUUID().toString();
            String topic = globals.getTopic();

            /*Message message = new Message();
            message.setId(uuid);
            message.setMsg(msg);
            message.setSendTime(new Date());*/

            kafkaTemplate.send(topic, uuid, msg);

        }catch (Exception e){
            logger.error("KafkaSender发送消息异常",e);
        }

    }



}
