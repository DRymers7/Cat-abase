package com.catabase.mockdataserver.services;

import com.catabase.mockdataserver.exceptions.GenericMockDataServerException;
import com.catabase.mockdataserver.model.responses.DogApiResponse;
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
public class DogPicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatPicService.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @Value(value = "${dogs-api.url}")
    private String baseApiUrl;

    public DogApiResponse getDogPicture(String breed) throws GenericMockDataServerException {
        try {
            LOGGER.info("Making request for dog picture at " + System.currentTimeMillis());
            String url = baseApiUrl + breed + "/images/random";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<DogApiResponse> requestEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<DogApiResponse> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, DogApiResponse.class);
            return response.getBody();
        } catch (ResponseStatusException e) {
            throw new GenericMockDataServerException("Could not get picture of dog.");
        }
    }

}
