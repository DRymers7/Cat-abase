package com.catabase.mockdataproducerv2;

import com.catabase.mockdataproducerv2.factory.ObjectFactory;
import com.catabase.mockdataproducerv2.factory.objectdao.*;
import com.catabase.mockdataproducerv2.model.pojos.Pet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FactoryTests {

    private ObjectFactory objectFactory;


    @Before
    public void setup() {
        objectFactory = new ObjectFactory();
    }

    @Test
    public void test_create_object_creates_object() {
        Pet pet = objectFactory.createNewPet();
        System.out.println("hello");
        Assert.assertNotNull(pet);
    }
}
