package com.catabase.mockdataproducerv2.model.repository;

import com.catabase.mockdataproducerv2.model.data.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CrudRepository<Cat, Integer> {

}

