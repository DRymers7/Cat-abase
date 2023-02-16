package com.catabase.mockdataserver.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {

        try {
            kafkaTemplate.send("cat-data", message);
        } catch (Exception e) {
            log.info("Failed: " + e.getMessage());
        }

    }

}
