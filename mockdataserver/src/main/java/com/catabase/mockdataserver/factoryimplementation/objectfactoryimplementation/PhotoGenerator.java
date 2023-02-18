package com.catabase.mockdataserver.factoryimplementation.objectfactoryimplementation;

import com.catabase.mockdataserver.factoryimplementation.objectdao.PhotoGeneratorDao;
import com.catabase.mockdataserver.services.CatPicService;
import com.catabase.mockdataserver.services.DogPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@Scope("singleton")
public class PhotoGenerator implements PhotoGeneratorDao {

    @Autowired
    private CatPicService catPicService;

    @Autowired
    private DogPicService dogPicService;


    @Override
    public Image getPetPhotos(String petType, String breed) {
        return handlePhotoCall(petType, breed);
    }

    private Image handlePhotoCall(String petType, String breed) {
        return null;
    }

}
