package com.catabase.mockdataproducerv2.controller;

import com.catabase.mockdataproducerv2.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FactoryController {

    private final ObjectFactory objectFactory;
    private boolean factoryStatus = false;

    public FactoryController(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    @GetMapping("object-factory/start")
    public void startObjectProduction() {
        factoryStatus = true;
        try {
            while (factoryStatus) {
                objectFactory.createNewPet();
                wait(10000);
            }
        } catch (InterruptedException e) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("object-factory/stop")
    public String stopObjectProduction() {
        this.factoryStatus = false;
        return "Factory has stopped.";
    }

}
