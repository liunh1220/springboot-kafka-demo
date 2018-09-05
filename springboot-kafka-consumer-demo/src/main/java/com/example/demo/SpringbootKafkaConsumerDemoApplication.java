package com.example.demo;

import com.example.demo.config.KafkaConsumerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({KafkaConsumerConfig.class})
@SpringBootApplication
public class SpringbootKafkaConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaConsumerDemoApplication.class, args);
	}
}
