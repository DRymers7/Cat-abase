package com.catabase.mockdataserver.factoryimplementation;

import com.catabase.mockdataserver.factoryimplementation.objectdao.AttributesGeneratorDao;
import com.catabase.mockdataserver.factoryimplementation.objectdao.ContactGeneratorDao;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PetObjectFactory {

    @Autowired
    private ContactGeneratorDao contactGeneratorDao;

    @Autowired
    private AttributesGeneratorDao attributesGeneratorDao;


}
