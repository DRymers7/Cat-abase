package com.catabase.mockdataproducerv2.controller;

import com.catabase.mockdataproducerv2.model.data.Cat;
import com.catabase.mockdataproducerv2.model.data.Dog;
import com.catabase.mockdataproducerv2.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class HealthCheck {

    @Autowired
    private DataService dataService;

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

}
