package com.catabase.mockdataproducerv2.controller;

import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;
import com.catabase.mockdataproducerv2.factory.ObjectFactory;
import com.catabase.mockdataproducerv2.model.data.Cat;
import com.catabase.mockdataproducerv2.model.data.Dog;
import com.catabase.mockdataproducerv2.model.pojos.Pet;
import com.catabase.mockdataproducerv2.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

@RestController
public class HealthCheck {

    @Autowired
    private DataService dataService;

    @Autowired
    private ObjectFactory objectFactory;

    @GetMapping("/health-check/{id}")
    public String conductDataHealthCheck(@PathVariable Integer id) {
        try {
            Cat catPull = dataService.getCatBreedFromDatabase(id);
            Dog dogPull = dataService.getDogBreedFromDatabase(id);
            if (catPull == null || dogPull == null) {
                throw new SQLException("Healthcheck failed");
            }
            return catPull + "\n" + dogPull;
        } catch (SQLException e) {
            return "Healthcheck failed.";
        }
    }

    @GetMapping("/health-check/object")
    public Pet dataGenerationWorking() {
        try {
            return objectFactory.createNewPet();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
        }
    }


}
