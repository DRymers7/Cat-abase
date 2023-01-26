package com.catabase.server.dao.jdbc;

import com.catabase.server.dao.dao.UserAccountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserAccountDao implements UserAccountDao {

    private static final Logger log = LoggerFactory.getLogger(JdbcUserAccountDao.class);
    private JdbcTemplate jdbcTemplate;

    public JdbcUserAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



}
