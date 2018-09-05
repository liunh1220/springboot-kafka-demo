package com.example.demo.service;

import com.example.demo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liulanhua on 2018/9/5.
 */
public class KafkaSenderTest extends BaseTest {

    @Autowired
    private KafkaSender sender;

    @Test
    public void send() throws Exception {
        sender.send("这是Kafka发送的消息内容");
    }

}