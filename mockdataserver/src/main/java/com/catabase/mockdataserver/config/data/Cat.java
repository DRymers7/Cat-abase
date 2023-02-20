package com.catabase.mockdataserver.config.data;

import jakarta.persistence.*;

@Entity
public class Cat {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String breed;

}
