package com.catabase.mockdataserver.config.repository;

import com.catabase.mockdataserver.config.data.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Integer> {
}
