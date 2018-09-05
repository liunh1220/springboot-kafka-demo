package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liulanhua on 2018/8/31.
 */
@Configuration
public class Globals {


    @Value("${spring.kafka.template.default-topic:test}")
    private String topic;


    public String getTopic() {
        return topic;
    }
}
