package com.catabase.mockdataserver.config.repository;

import com.catabase.mockdataserver.config.data.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Integer> {
}
