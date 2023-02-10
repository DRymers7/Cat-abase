package com.catabase.mockdataserver.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CatPicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatPicService.class);
    private final RestTemplate restTemplate;
    @Value("${catsApiUrl}")
    private String baseApiUrl;

    public CatPicService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Image getCatPicture() throws InterruptedException, ExecutionException {
        try {
            LOGGER.info("Making request for cat picture at " + System.currentTimeMillis());
            String url = baseApiUrl + "/cat";
            return restTemplate.getForObject(url, Image.class);
        } catch (ResponseStatusException e) {
            throw new ExecutionException(e.getReason(), e);
        }
    }

}
