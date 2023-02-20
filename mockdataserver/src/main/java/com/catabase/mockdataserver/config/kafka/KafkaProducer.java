package com.catabase.mockdataserver.config.kafka;

import com.catabase.mockdataserver.model.Pet;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class KafkaProducer {

    private final KafkaTemplate<String, Pet> kafkaTemplate;

    public void sendMessage(Pet message) {

        try {
            kafkaTemplate.send("cat-data", message);
        } catch (Exception e) {
            log.info("Failed: " + e.getMessage());
        }

    }

}
