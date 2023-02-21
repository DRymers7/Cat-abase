package com.catabase.mockdataproducerv2.factory.objectproducers;

import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;
import com.catabase.mockdataproducerv2.factory.objectdao.PhotoGeneratorDao;
import com.catabase.mockdataproducerv2.model.pojos.responses.CatApiResponse;
import com.catabase.mockdataproducerv2.model.pojos.responses.DogApiResponse;
import com.catabase.mockdataproducerv2.services.CatPicService;
import com.catabase.mockdataproducerv2.services.DogPicService;
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
    public String getPetPhotos(String petType, String breed) throws GenericProducerServerException {
        return handlePhotoCall(petType, breed);
    }

    private String handlePhotoCall(String petType, String breed) throws GenericProducerServerException {
        if (petType.equalsIgnoreCase("dog")) {
            return returnDogPicture(breed);
        } else if (petType.equalsIgnoreCase("cat")) {
            return returnCatPicture(breed);
        } else {
            throw new GenericProducerServerException("Cannot find pet of type " + petType);
        }
    }

    private String returnDogPicture(String breed) throws GenericProducerServerException {
        DogApiResponse dogPicture = dogPicService.getDogPicture(breed);
        return dogPicture.getMessage();
    }

    private String returnCatPicture(String breed) throws GenericProducerServerException {
        CatApiResponse catPicture = catPicService.getCatPicture(breed);
        return catPicture.getImageLink();
    }

}
