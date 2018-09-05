package com.example.demo.controller;

import com.example.demo.service.KafkaSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by liulanhua on 2018/8/31.
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaSender kafkaSender;


    @RequestMapping("/send")
    public String sendKafka() {
        try {
            String message = "kafka的消息 "+ new Date();
            logger.info("kafka的消息={}", message);
            kafkaSender.send(message);
            return "发送kafka成功";
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return "发送kafka失败";
        }
    }



}
