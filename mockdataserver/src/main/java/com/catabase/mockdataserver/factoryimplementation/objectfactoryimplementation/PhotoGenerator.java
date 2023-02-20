package com.catabase.mockdataserver.factoryimplementation.objectfactoryimplementation;

import com.catabase.mockdataserver.exceptions.GenericMockDataServerException;
import com.catabase.mockdataserver.factoryimplementation.objectdao.PhotoGeneratorDao;
import com.catabase.mockdataserver.model.responses.CatApiResponse;
import com.catabase.mockdataserver.model.responses.DogApiResponse;
import com.catabase.mockdataserver.services.CatPicService;
import com.catabase.mockdataserver.services.DogPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class PhotoGenerator implements PhotoGeneratorDao {

    @Autowired
    private CatPicService catPicService;

    @Autowired
    private DogPicService dogPicService;


    @Override
    public String getPetPhotos(String petType, String breed) throws GenericMockDataServerException {
        return handlePhotoCall(petType, breed);
    }

    private String handlePhotoCall(String petType, String breed) throws GenericMockDataServerException {
        if (petType.equalsIgnoreCase("dog")) {
            return returnDogPicture(breed);
        } else if (petType.equalsIgnoreCase("cat")) {
            return returnCatPicture(breed);
        } else {
            throw new GenericMockDataServerException("Cannot find pet of type " + petType);
        }
    }

    private String returnDogPicture(String breed) throws GenericMockDataServerException {
        DogApiResponse dogPicture = dogPicService.getDogPicture(breed);
        return dogPicture.getMessage();
    }

    private String returnCatPicture(String breed) throws GenericMockDataServerException {
        CatApiResponse catPicture = catPicService.getCatPicture(breed);
        return catPicture.getImageLink();
    }

}
