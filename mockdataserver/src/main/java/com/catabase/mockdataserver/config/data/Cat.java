package com.catabase.mockdataserver.config.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cat {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String breed;

}
