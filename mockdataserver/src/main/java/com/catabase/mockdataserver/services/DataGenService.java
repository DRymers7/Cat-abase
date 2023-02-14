package com.catabase.mockdataserver.services;

import com.catabase.mockdataserver.factory.PetFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataGenService {

    @Autowired
    private PetFactory petFactory;



}
