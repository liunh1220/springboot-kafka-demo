package com.example.demo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import com.example.demo.config.KafkaProducerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@Import({KafkaProducerConfig.class})
@EnableDubboConfig
public class SpringbootKafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaDemoApplication.class, args);
	}
}
