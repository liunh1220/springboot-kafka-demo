package com.example.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Kafka消费者
 * Created by liulanhua on 2018/8/31.
 */
@Component
public class KafkaConsumer {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = {"${spring.kafka.template.default-topic}"})
    public void listen(ConsumerRecord<?, ?> record) {
        try {
            logger.info("kafka的key: " + record.key());
            logger.info("kafka的value: " + record.value().toString());
            //logger.info("kafka的value: " + record.value());
        } catch (Exception e) {
            logger.error("kafka接收消息异常",e);
        }
    }


}
