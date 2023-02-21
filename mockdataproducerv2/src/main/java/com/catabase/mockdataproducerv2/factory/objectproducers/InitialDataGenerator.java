package com.catabase.mockdataproducerv2.factory.objectproducers;

import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;
import com.catabase.mockdataproducerv2.factory.objectdao.InitialDataGenDao;
import com.catabase.mockdataproducerv2.services.DataService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@NoArgsConstructor
public class InitialDataGenerator implements InitialDataGenDao {


    @Autowired
    private DataService dataService;

    private SecureRandom random = new SecureRandom();

    @Override
    public Map<String, List<String>> initializeSetupData() throws GenericProducerServerException {
        try {
            int countCatBreeds = dataService.countCatBreeds();
            int countDogBreeds = dataService.countDogBreeds();
            String dogOrCat = determineIfDogOrCat();
            if (dogOrCat.equalsIgnoreCase("cat")) {
                return determineBreed(dogOrCat, countCatBreeds);
            } else {
                return determineBreed(dogOrCat, countDogBreeds);
            }
        } catch (SQLException | RuntimeException e) {
            throw new GenericProducerServerException("Could not initialize data.");
        }
    }

    private String determineIfDogOrCat() {
        int tempValue = random.nextInt(0, 2);
        return tempValue == 0 ? "Cat" : "Dog";
    }

    private Map<String, List<String>> determineBreed(String petType, int countOfBreeds) throws GenericProducerServerException {
        Map<String, List<String>> map = new HashMap<>();
        int numBreeds = random.nextInt(0, 3);
        List<Integer> breedNums = new ArrayList<>();
        for (int i = 0; i < numBreeds; i++) {
            breedNums.add(random.nextInt(0, countOfBreeds-1));
        }
        List<String> breeds = determineNumberAndTypeOfBreeds(petType, breedNums);
        map.put(petType, breeds);
        return map;
    }

    private List<String> determineNumberAndTypeOfBreeds(String petType, List<Integer> randomBreeds) throws GenericProducerServerException {
        List<String> breeds = new ArrayList<>();

        if (petType.equalsIgnoreCase("cat")) {
            randomBreeds.forEach((breedNum) -> {
                try {
                    breeds.add(dataService.getCatBreedFromDatabase(breedNum).getBreed());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        } else {
            randomBreeds.forEach((breedNum) -> {
                try {
                    breeds.add(dataService.getDogBreedFromDatabase(breedNum).getBreed());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return breeds;

    }


}
