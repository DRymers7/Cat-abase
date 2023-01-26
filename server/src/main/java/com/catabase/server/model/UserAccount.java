package com.catabase.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UserAccount {

    public UserAccount(){};
    private int userId;
    private String userName;
    private BigDecimal balance;
    private boolean ownsOtherPets;
    private int userAge;
    private String activityLevel;
    private boolean worksFromHome;
    private String userAddress;
    private String userStateProvince;
    private String userCountry;


    
}
