package com.catabase.mockdataproducerv2.factory;

import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;
import com.catabase.mockdataproducerv2.factory.objectdao.*;
import com.catabase.mockdataproducerv2.model.pojos.Pet;
import com.catabase.mockdataproducerv2.model.pojos.objects.Attributes;
import com.catabase.mockdataproducerv2.model.pojos.objects.Breed;
import com.catabase.mockdataproducerv2.model.pojos.objects.Contact;
import com.catabase.mockdataproducerv2.model.pojos.objects.Environment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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

    @Autowired
    private FinalDataGeneratorDao finalDataGeneratorDao;

    public Pet createNewPet() {
        return handleCreationDetails();
    }

    private Pet handleCreationDetails() {
        try {
            log.info("Producing new pet at " + System.currentTimeMillis());
            Map<String, List<String>> petInformation = initialDataGenDao.initializeSetupData();
            return setPetCharacteristics(new Pet(), petInformation);
        } catch (GenericProducerServerException e) {
            log.info("Failed to produce new pet at " + System.currentTimeMillis());
            throw new RuntimeException();
        }
    }

    private Pet setPetCharacteristics(Pet pet, Map<String, List<String>> petInfo) throws GenericProducerServerException {
        String petType = petInfo.keySet().iterator().next();
        List<String> petBreed = petInfo.get(petType);
        setBreeds(pet, petBreed);
        pet.setAttributes(generateAttributes(petType));
        pet.setContact(generateContact());
        pet.setEnvironment(generateEnvironment(petType));
        pet.setPhotos(generatePhotos(petType, petBreed.get(0)));
        setRemainingDetails(pet, petType);
        return pet;
    }

    private Attributes generateAttributes(String petType) {
        return attributesGeneratorDao.generateAttributes(petType);
    }

    private Contact generateContact() {
        return contactGeneratorDao.generateContact();
    }

    private Environment generateEnvironment(String petType) {
        return environmentGeneratorDao.generateEnvironment(petType);
    }

    private String[] generatePhotos(String petType, String breed) throws GenericProducerServerException {
        String returnValue = photoGeneratorDao.getPetPhotos(petType, breed);
        return new String[]{returnValue};
    }

    private void setBreeds(Pet pet, List<String> breeds) {
        Breed breed = new Breed();
        if (breeds.size() == 1) {
            breed.setPrimary(breeds.get(0));
        } else if (breeds.size() == 2) {
            breed.setPrimary(breeds.get(0));
            breed.setSecondary(breeds.get(1));
        } else {
            breed.setPrimary(breeds.get(0));
            breed.setSecondary(breeds.get(1));
            breed.setMixed(true);
        }
    }

    private void setRemainingDetails(Pet pet, String petType) throws GenericProducerServerException{
        finalDataGeneratorDao.generateAndPatchRemainingData(pet, petType);
    }

}
