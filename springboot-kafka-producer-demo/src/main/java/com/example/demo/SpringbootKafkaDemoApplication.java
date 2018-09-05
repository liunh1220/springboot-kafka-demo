package com.example.demo;

import com.example.demo.config.KafkaProducerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({KafkaProducerConfig.class})
@SpringBootApplication
public class SpringbootKafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaDemoApplication.class, args);
	}
}
