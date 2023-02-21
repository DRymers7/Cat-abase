package com.catabase.mockdataproducerv2.services;

import com.catabase.mockdataproducerv2.model.data.Cat;
import com.catabase.mockdataproducerv2.model.data.Dog;
import com.catabase.mockdataproducerv2.model.repository.CatRepository;
import com.catabase.mockdataproducerv2.model.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DataService {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private DogRepository dogRepository;

    public Cat getCatBreedFromDatabase(int id) throws SQLException {
        try {
            return catRepository.findById(id).get();
        } catch (DataAccessException e) {
            throw new SQLException(e.getCause());
        }
    }

    public Dog getDogBreedFromDatabase(int id) throws SQLException {
        try {
            return dogRepository.findById(id).get();
        } catch (DataAccessException e) {
            throw new SQLException(e.getCause());
        }
    }

    public int countCatBreeds() throws SQLException {
        try {
            return Math.toIntExact(catRepository.count());
        } catch (DataAccessException e) {
            throw new SQLException(e.getCause());
        }
    }

    public int countDogBreeds() throws SQLException {
        try {
            return Math.toIntExact(dogRepository.count());
        } catch (DataAccessException e) {
            throw new SQLException(e.getCause());
        }
    }

}
