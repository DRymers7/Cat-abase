package com.catabase.mockdataproducerv2.services;

import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;
import com.catabase.mockdataproducerv2.model.pojos.responses.CatApiResponse;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@NoArgsConstructor
public class CatPicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatPicService.class);
    private final RestTemplate restTemplate = new RestTemplate();
    @Value(value = "${cats-api.url}")
    private String baseApiUrl;

    @Value(value = "${cats-api.api-key}")
    private String apiKey;

    public CatApiResponse getCatPicture(String breed) throws GenericProducerServerException {
        try {
            LOGGER.info("Making request for cat picture at " + System.currentTimeMillis());
            String url = baseApiUrl + "?name=" + breed;
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.add("x-api-key", apiKey);
            HttpEntity<CatApiResponse> requestEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<CatApiResponse> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, CatApiResponse.class);
            return response.getBody();
        } catch (ResponseStatusException e) {
            throw new GenericProducerServerException("Could not obtain cat picture");
        }
    }

}