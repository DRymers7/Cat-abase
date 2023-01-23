package com.catabase.server.controller;

import com.catabase.server.dao.dao.UserDao;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    

}
