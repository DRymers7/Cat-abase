package com.catabase.server.config.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserServiceThread implements Runnable {

    /*
    Proper configuration for manual management of threads
     */

    private final Logger log = LoggerFactory.getLogger(UserServiceThread.class);

    @Override
    public void run() {
        log.info("UserServiceThread Started at " + System.currentTimeMillis());
    }
}
