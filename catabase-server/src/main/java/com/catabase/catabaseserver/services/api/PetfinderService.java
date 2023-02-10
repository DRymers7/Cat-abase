package com.catabase.catabaseserver.services.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
public class PetfinderService {

    private final Logger log = LoggerFactory.getLogger(PetfinderService.class);

    @Value("${petfinder.api.public.key}")
    private String petfinderPublicKey;

    @Value("${petfinder.api.secret.key}")
    private String petfinderSecretKey;


}
