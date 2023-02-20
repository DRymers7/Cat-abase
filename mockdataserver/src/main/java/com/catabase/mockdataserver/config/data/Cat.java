package com.catabase.mockdataserver.config.data;

import jakarta.persistence.*;

@Table(name = "cat")
@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String breed;

}
