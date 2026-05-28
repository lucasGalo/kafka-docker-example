package com.denzhn.kafka.docker.example.service.impl;

import com.denzhn.kafka.docker.example.service.KafkaProducerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {
    public static final String DEMO_TOPIC= "denzhn-topic";
    private static final Logger log = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);
    private final KafkaTemplate<String, String> template;

    public KafkaProducerServiceImpl(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @Override
    @Scheduled(fixedRate = 3000)
    public void send() {
        log.info("Sending message to topic: {}", DEMO_TOPIC);

        template.send(DEMO_TOPIC, "Wow we are running kafka with docker!");
    }

    @KafkaListener(topics = DEMO_TOPIC, groupId = "denzhn-group")
    public void litener(ConsumerRecord<String, String> record) {
        log.info("Received message: {}", record.value());
    }
}
