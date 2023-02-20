package com.catabase.mockdataserver.factoryimplementation.objectfactoryimplementation;

import com.catabase.mockdataserver.config.repository.CatRepository;
import com.catabase.mockdataserver.config.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitialDataGenerator {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private DogRepository dogRepository;



}
