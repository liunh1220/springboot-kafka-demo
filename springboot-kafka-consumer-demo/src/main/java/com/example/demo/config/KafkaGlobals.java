package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * kafka配置参数
 * Created by liulanhua on 2018/12/11.
 */
@Component
@Configuration
public class KafkaGlobals {



    /** ================================== kafka base ============================================== */

    @Value("${spring.kafka.bootstrap-servers:192.168.126.124:9092}")
    private String servers;

    @Value("${spring.kafka.template.default-topic:test}")
    private String topic;



    /** ================================== kafka producer ============================================== */

    @Value("${spring.kafka.producer.acks:all}")
    private String acks;

    @Value("${spring.kafka.producer.batch-size:10}")
    private int batchSize;

    @Value("${spring.kafka.producer.retries:0}")
    private int retries;

    @Value("${spring.kafka.producer.buffer-memory:33554432}")
    private int bufferMemory;

    @Value("${spring.kafka.producer.key-serializer:org.apache.kafka.common.serialization.StringSerializer}")
    private String keySerializer;

    @Value("${spring.kafka.producer.value-serializer:org.apache.kafka.common.serialization.StringSerializer}")
    private String valueSerializer;

    @Value("${spring.kafka.producer.linger:1}")
    private int linger;



    /** ================================== kafka consumer ============================================== */

    @Value("${spring.kafka.consumer.enable-auto-commit:true}")
    private boolean enableAutoCommit;

    @Value("${spring.kafka.consumer.group-id:liby_group}")
    private String groupId;

    @Value("${spring.kafka.consumer.max-poll-records:10}")
    private int maxPollRecords;

    @Value("${spring.kafka.consumer.key-deserializer:org.apache.kafka.common.serialization.StringDeserializer}")
    private String keyDeserializer;

    @Value("${spring.kafka.consumer.value-deserializer:org.apache.kafka.common.serialization.StringDeserializer}")
    private String valueDeserializer;

    @Value("${spring.kafka.consumer.auto-commit-interval}")
    private int autoCommitInterval;

    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;

    @Value("${spring.kafka.consumer.session.timeout}")
    private int sessionTimeout;



    /** ================================== kafka listener ============================================== */

    @Value("${spring.kafka.listener.concurrency:3}")
    private int concurrency;

    //@Value("${spring.kafka.listener.ack-mode:org.springframework.kafka.listener.AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE}")
    private String ackMode;





    /** ================================== kafka set get ============================================== */

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAcks() {
        return acks;
    }

    public void setAcks(String acks) {
        this.acks = acks;
    }

    public int getBufferMemory() {
        return bufferMemory;
    }

    public void setBufferMemory(int bufferMemory) {
        this.bufferMemory = bufferMemory;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
    }

    public int getLinger() {
        return linger;
    }

    public void setLinger(int linger) {
        this.linger = linger;
    }

    public boolean isEnableAutoCommit() {
        return enableAutoCommit;
    }

    public void setEnableAutoCommit(boolean enableAutoCommit) {
        this.enableAutoCommit = enableAutoCommit;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getMaxPollRecords() {
        return maxPollRecords;
    }

    public void setMaxPollRecords(int maxPollRecords) {
        this.maxPollRecords = maxPollRecords;
    }

    public String getKeyDeserializer() {
        return keyDeserializer;
    }

    public void setKeyDeserializer(String keyDeserializer) {
        this.keyDeserializer = keyDeserializer;
    }

    public String getValueDeserializer() {
        return valueDeserializer;
    }

    public void setValueDeserializer(String valueDeserializer) {
        this.valueDeserializer = valueDeserializer;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public int getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(int concurrency) {
        this.concurrency = concurrency;
    }

    public String getAckMode() {
        return ackMode;
    }

    public void setAckMode(String ackMode) {
        this.ackMode = ackMode;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public int getAutoCommitInterval() {
        return autoCommitInterval;
    }

    public void setAutoCommitInterval(int autoCommitInterval) {
        this.autoCommitInterval = autoCommitInterval;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}
