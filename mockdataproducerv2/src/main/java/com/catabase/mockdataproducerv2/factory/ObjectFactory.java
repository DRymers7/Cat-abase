package com.catabase.mockdataproducerv2.factory;

import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;
import com.catabase.mockdataproducerv2.factory.objectdao.*;
import com.catabase.mockdataproducerv2.model.pojos.Pet;
import com.catabase.mockdataproducerv2.model.pojos.objects.Attributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class ObjectFactory {

    @Autowired
    private InitialDataGenDao initialDataGenDao;

    @Autowired
    private AttributesGeneratorDao attributesGeneratorDao;

    @Autowired
    private ContactGeneratorDao contactGeneratorDao;

    @Autowired
    private EnvironmentGeneratorDao environmentGeneratorDao;

    @Autowired
    private PhotoGeneratorDao photoGeneratorDao;

    public Pet createNewPet() {
        return handleCreationDetails();
    }

    private Pet handleCreationDetails() {
        try {
            Pet pet = new Pet();
            Map<String, String> petInformation = initialDataGenDao.initializeSetupData();
            return setPetCharacteristics(pet, petInformation);
        } catch (GenericProducerServerException e) {
            log.info("Failed to produce new pet at " + System.currentTimeMillis());
        }


    }

    private Pet setPetCharacteristics(Pet pet, Map<String, String> petInfo) {

    }

    private Attributes generateAttributes(String petType) {
        return attributesGeneratorDao.generateAttributes(petType);
    }




}
