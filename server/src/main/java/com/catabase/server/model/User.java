package com.catabase.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {

    public User() {}

    @Id
    private int userId;
    private int userEmail;
    @JsonIgnore
    private int passwordHash;
    private String role;

}
