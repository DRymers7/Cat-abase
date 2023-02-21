package com.catabase.mockdataproducerv2.factory.objectdao;

import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;
import com.catabase.mockdataproducerv2.model.pojos.Pet;

public interface FinalDataGeneratorDao {

    void generateAndPatchRemainingData(Pet pet, String petType) throws GenericProducerServerException;

}
