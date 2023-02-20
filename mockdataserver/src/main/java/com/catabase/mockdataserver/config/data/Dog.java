package com.catabase.mockdataserver.config.data;

import jakarta.persistence.*;

@Table(name = "dog")
@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String Breed;

}
