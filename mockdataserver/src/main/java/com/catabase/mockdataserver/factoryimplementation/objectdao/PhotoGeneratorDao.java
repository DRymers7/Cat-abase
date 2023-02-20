package com.catabase.mockdataserver.factoryimplementation.objectdao;

import com.catabase.mockdataserver.exceptions.GenericMockDataServerException;

import java.awt.*;

public interface PhotoGeneratorDao {

    String getPetPhotos(String petType, String breed) throws GenericMockDataServerException;

}
