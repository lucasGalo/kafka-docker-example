package com.denzhn.kafka.docker.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.denzhn.kafka.docker.example.service.impl.KafkaProducerServiceImpl.DEMO_TOPIC;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createDemoTopic(){
        return new NewTopic(DEMO_TOPIC, 3, (short) 1);
    }
}
