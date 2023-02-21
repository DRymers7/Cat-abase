package com.catabase.mockdataproducerv2.factory.objectdao;

import com.catabase.mockdataproducerv2.model.pojos.objects.Environment;

public interface EnvironmentGeneratorDao {

    Environment generateEnvironment(String petType);

}
