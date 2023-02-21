package com.catabase.mockdataproducerv2.model.repository;

import com.catabase.mockdataproducerv2.model.data.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Integer> {

}

