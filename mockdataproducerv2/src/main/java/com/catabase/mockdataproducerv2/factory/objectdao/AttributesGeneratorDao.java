package com.catabase.mockdataproducerv2.factory.objectdao;


import com.catabase.mockdataproducerv2.model.pojos.objects.Attributes;

public interface AttributesGeneratorDao {

    Attributes generateAttributes(String petType);

}
