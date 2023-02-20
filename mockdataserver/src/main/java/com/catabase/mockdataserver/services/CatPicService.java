package com.catabase.mockdataserver.services;

import com.catabase.mockdataserver.exceptions.GenericMockDataServerException;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@NoArgsConstructor
public class CatPicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatPicService.class);
    private final RestTemplate restTemplate = new RestTemplate();
    @Value(value = "${cats-api.url}")
    private String baseApiUrl;

    @Value(value = "${cats-api.api-key}")

    public Image getCatPicture() throws GenericMockDataServerException {
        try {
            LOGGER.info("Making request for cat picture at " + System.currentTimeMillis());
            String url = baseApiUrl + "/cat";
            return restTemplate.getForObject(url, Image.class);
        } catch (ResponseStatusException e) {
            throw new GenericMockDataServerException("Could not obtain cat picture");
        }
    }

}
