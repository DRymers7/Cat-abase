package com.catabase.mockdataserver.services;

import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
public class DogPicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatPicService.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @Value(value = "${dogs-api.url}")
    private String baseApiUrl;

}
