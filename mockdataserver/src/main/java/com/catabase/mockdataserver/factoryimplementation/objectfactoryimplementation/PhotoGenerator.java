package com.catabase.mockdataserver.factoryimplementation.objectfactoryimplementation;

import com.catabase.mockdataserver.factoryimplementation.objectdao.PhotoGeneratorDao;
import com.catabase.mockdataserver.services.CatPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@Scope("singleton")
public class PhotoGenerator implements PhotoGeneratorDao {

    @Autowired
    private CatPicService catPicService;

    private String petType;

    @Override
    public Image getPetPhotos() {
        return handlePhotoCall();
    }

    private Image handlePhotoCall() {
        return null;
    }

}
