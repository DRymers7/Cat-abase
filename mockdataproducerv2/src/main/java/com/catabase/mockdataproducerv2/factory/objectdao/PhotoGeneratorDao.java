package com.catabase.mockdataproducerv2.factory.objectdao;


import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;

public interface PhotoGeneratorDao {

    String getPetPhotos(String petType, String breed) throws GenericProducerServerException;

}
