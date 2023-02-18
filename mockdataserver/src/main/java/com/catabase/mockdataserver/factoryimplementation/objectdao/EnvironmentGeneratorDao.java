package com.catabase.mockdataserver.factoryimplementation.objectdao;

import com.catabase.mockdataserver.model.objects.Environment;

public interface EnvironmentGeneratorDao {

    Environment generateEnvironment(String petType);

}
