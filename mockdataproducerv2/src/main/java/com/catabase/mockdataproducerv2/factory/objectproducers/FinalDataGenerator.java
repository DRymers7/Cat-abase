package com.catabase.mockdataproducerv2.factory.objectproducers;

import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;
import com.catabase.mockdataproducerv2.factory.objectdao.FinalDataGeneratorDao;
import com.catabase.mockdataproducerv2.model.pojos.Pet;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Locale;

@Component
@Slf4j
public class FinalDataGenerator implements FinalDataGeneratorDao {

    private final FakeValuesService fakeValuesService =
            new FakeValuesService(new Locale("en-US"), new RandomService());

    private final Faker usFaker =
            new Faker(new Locale("en-US"));

    private final SecureRandom random = new SecureRandom();

    public FinalDataGenerator() {}

    @Override
    public void generateAndPatchRemainingData(Pet pet, String petType) throws GenericProducerServerException {
        setMainFields(pet, petType);
    }

    private void setMainFields(Pet pet, String petType) throws GenericProducerServerException {
        pet.setPetType(petType);
        setNameOfPet(pet);
        pet.setUrl("www.petfinder.com/pet/" + usFaker.code());
        pet.setAge(random.nextInt(0, 11));
        setGenderOfPet(pet);
        setSizeOfPet(pet);
        setPetCoat(pet);
        validateObjects(pet);
    }

    private void setNameOfPet(Pet pet) {
        if (pet.getPetType().equalsIgnoreCase("dog")) {
            pet.setPetName(usFaker.resolve("creature.dog.name"));
        } else {
            pet.setPetName(usFaker.resolve("creature.cat.name"));
        }
    }

    private void setGenderOfPet(Pet pet) {
        if (random.nextInt(0, 2) == 0) {
            pet.setGender("Female");
        } else {
            pet.setGender("Male");
        }
    }

    private void setSizeOfPet(Pet pet) {
        int num = random.nextInt(0, 3);
        if (num == 0) {
            pet.setSize("Small");
        } else if (num == 1) {
            pet.setSize("Medium");
        } else {
            pet.setSize("Large");
        }
    }

    private void setPetCoat(Pet pet) {
        int num = random.nextInt(0, 3);
        if (num == 0) {
            pet.setCoat("Light Shedder");
        } else if (num == 1) {
            pet.setCoat("Medium Shedder");
        } else {
            pet.setCoat("Heavy Shedder");
        }
    }
    private void validateObjects(Pet pet) throws GenericProducerServerException {
        if (pet.getAttributes() == null || pet.getEnvironment() == null || pet.getContact() == null) {
            log.info("Validating object");
            throw new GenericProducerServerException("Objects created incorrectly.");
        }
    }


}
