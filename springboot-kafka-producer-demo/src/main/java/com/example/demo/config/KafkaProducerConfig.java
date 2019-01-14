package com.example.demo.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liulanhua on 2018/8/31.
 */
@Configuration
@ComponentScan({"com.example.demo"})
@EnableKafka
public class KafkaProducerConfig implements WebMvcConfigurer {

    @Autowired
    private KafkaGlobals kafkaGlobals;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars*")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


    @Bean(name = "hostName")
    public String getHostName(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "mybatis-demo";
    }

/*

    @Bean
    public KafkaTemplate<String,?> kafkaTemplate(){
        KafkaTemplate<String,?> kafkaTemplate = new KafkaTemplate<String, Object>(producerFactory());
        kafkaTemplate.setDefaultTopic(kafkaGlobals.getTopic());
        return kafkaTemplate;
    }


    private Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaGlobals.getServers());
        props.put(ProducerConfig.RETRIES_CONFIG, kafkaGlobals.getRetries());
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaGlobals.getBatchSize());
        props.put(ProducerConfig.LINGER_MS_CONFIG, kafkaGlobals.getLinger());
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, kafkaGlobals.getBufferMemory());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaGlobals.getKeySerializer());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaGlobals.getValueSerializer());
        return props;
    }

    private ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }
*/


}
