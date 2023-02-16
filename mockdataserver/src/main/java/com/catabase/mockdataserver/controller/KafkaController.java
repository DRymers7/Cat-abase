package com.catabase.mockdataserver.controller;

import com.catabase.mockdataserver.config.KafkaProducer;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class KafkaController {

    private final StreamsBuilderFactoryBean factoryBean;
    private final KafkaProducer kafkaProducer;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);



}
