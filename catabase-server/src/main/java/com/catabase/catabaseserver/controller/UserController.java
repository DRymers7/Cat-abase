package com.catabase.catabaseserver.controller;

import com.catabase.catabaseserver.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }



}
