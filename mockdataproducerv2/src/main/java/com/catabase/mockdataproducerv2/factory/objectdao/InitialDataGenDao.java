package com.catabase.mockdataproducerv2.factory.objectdao;

import com.catabase.mockdataproducerv2.exceptions.GenericProducerServerException;

import java.util.Map;

public interface InitialDataGenDao {

    Map<String, String> initializeSetupData() throws GenericProducerServerException;

}
