package com.catabase.catabaseserver.controller;

import com.catabase.catabaseserver.dao.UserAccountDao;
import com.catabase.catabaseserver.model.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;

@RestController
@CrossOrigin
public class UserAccountController {
    private static final Logger log = LoggerFactory.getLogger(UserAccountController.class);

    private UserAccountDao userAccountDao;

    public UserAccountController(UserAccountDao userAccountDao){
        this.userAccountDao = userAccountDao;
    }
    @GetMapping("/accounts")
    public UserAccount getUserAccount(Principal principal){
        try{
            return userAccountDao.getUserAccountInfo(1);
        }
        catch(SQLException ex){
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
    }
}