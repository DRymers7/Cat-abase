package com.catabase.mockdataproducerv2.factory.objectproducers;

import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;
import com.catabase.mockdataproducerv2.factory.objectdao.InitialDataGenDao;
import com.catabase.mockdataproducerv2.services.DataService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor
public class InitialDataGenerator implements InitialDataGenDao {


    @Autowired
    private DataService dataService;

    private SecureRandom random = new SecureRandom();

    @Override
    public Map<String, String> initializeSetupData() throws GenericProducerServerException {
        try {
            int countCatBreeds = dataService.countCatBreeds();
            int countDogBreeds = dataService.countDogBreeds();
            String dogOrCat = determineIfDogOrCat();
            if (dogOrCat.equalsIgnoreCase("cat")) {
                return determineBreed(dogOrCat, countCatBreeds);
            } else {
                return determineBreed(dogOrCat, countDogBreeds);
            }
        } catch (SQLException e) {
            throw new GenericProducerServerException("Could not initialize data.");
        }
    }

    private String determineIfDogOrCat() {
        int tempValue = random.nextInt(0, 2);
        return tempValue == 0 ? "Cat" : "Dog";
    }

    private Map<String, String> determineBreed(String petType, int countOfBreeds) throws GenericProducerServerException {
        Map<String, String> map = new HashMap<>();
        int randomBreed = random.nextInt(0, countOfBreeds-1);
        try {
            String breedName;
            if (petType.equalsIgnoreCase("cat")) {
                breedName = dataService.getCatBreedFromDatabase(randomBreed).getBreed();
            } else {
                breedName = dataService.getDogBreedFromDatabase(randomBreed).getBreed();
            }
            map.put(petType, breedName);
            return map;
        } catch (SQLException e) {
            throw new GenericProducerServerException(e.getMessage());
        }

    }


}
