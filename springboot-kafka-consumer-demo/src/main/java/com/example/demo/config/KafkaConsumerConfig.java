package com.example.demo.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Kafka配置
 * Created by liulanhua on 2018/8/31.
 */
@Configuration
@ComponentScan({"com.example.demo"})
@EnableKafka
public class KafkaConsumerConfig implements WebMvcConfigurer {

    @Autowired
    private KafkaGlobals kafkaGlobals;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars*")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /*@Bean
    public Globals globals() {
        return new Globals();
    }*/

    @Bean(name = "hostName")
    public String getHostName(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "mybatis-demo";
    }

    /**
     * 默认kafka监听工厂
     * 不支持批量接收数据
     * @return
     */
    @Bean(name = "defaultFactory")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> defaultFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = this.factory();
        factory.setBatchListener(false);
        return factory;
    }


    /**
     * 批量kafka监听工厂
     * 支持批量接收数据
     * @return
     */
    @Bean(name = "batchFactory")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> batchFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = this.factory();
        factory.setBatchListener(true);
        return factory;
    }


    private ConcurrentKafkaListenerContainerFactory factory(){
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(this.consumerFactory());
        factory.setConcurrency(kafkaGlobals.getConcurrency());
        factory.getContainerProperties().setPollTimeout(3000);
        if (!kafkaGlobals.isEnableAutoCommit()){
            // enableAutoCommit为false时才设置为手动ack
            factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);//设置提交偏移量的方式
        }
        return factory;
    }


    private ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(this.consumerConfigs());
    }

    private Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaGlobals.getServers());
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, kafkaGlobals.isEnableAutoCommit());
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, kafkaGlobals.getAutoCommitInterval());
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, kafkaGlobals.getSessionTimeout());
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaGlobals.getKeyDeserializer());
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaGlobals.getValueDeserializer());
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaGlobals.getGroupId());
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaGlobals.getAutoOffsetReset());
        propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, kafkaGlobals.getMaxPollRecords());//每个批次获取数
        return propsMap;
    }



}
