package com.catabase.server.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserAccount {
    private int userId;
    private BigDecimal balance;
    private boolean ownsOtherPets;
    private int userAge;
    private String activityLevel;
    private boolean worksFromHome;
    private String userAddress;
    private String userStateProvince;
    private String userCountry;
    private String userName;


    
}
