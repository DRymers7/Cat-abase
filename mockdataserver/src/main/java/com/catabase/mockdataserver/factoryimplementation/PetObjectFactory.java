package com.catabase.mockdataserver.factoryimplementation;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PetObjectFactory {

    private final FakeValuesService fakeValuesService =
            new FakeValuesService(new Locale("en-US"), new RandomService());

    private final Faker usFaker =
            new Faker(new Locale("en-US"));



}
