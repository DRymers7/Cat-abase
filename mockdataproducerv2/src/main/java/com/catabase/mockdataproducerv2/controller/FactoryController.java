package com.catabase.mockdataproducerv2.controller;

import com.catabase.mockdataproducerv2.factory.ObjectFactory;
import com.catabase.mockdataproducerv2.model.pojos.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
public class FactoryController {

    private final ObjectFactory objectFactory;
    private boolean factoryStatus = false;

    public FactoryController(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    @GetMapping("object-factory/start")
    public Pet startObjectProduction() {
        factoryStatus = true;
        try {
            log.info("Creating new pet at " + System.currentTimeMillis());
            return objectFactory.createNewPet();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("object-factory/stop")
    public String stopObjectProduction() {
        this.factoryStatus = false;
        return "Factory has stopped.";
    }

}
