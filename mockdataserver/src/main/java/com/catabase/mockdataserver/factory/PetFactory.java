package com.catabase.mockdataserver.factory;

import com.catabase.mockdataserver.model.Pet;
import com.catabase.mockdataserver.services.CatPicService;
import org.springframework.stereotype.Component;

@Component
public class PetFactory {

    private final CatPicService catPicService;

    public PetFactory(CatPicService catPicService) {
        this.catPicService = catPicService;
    }

    public static Pet createPet(String type) {
        return null;
    }

}
