package com.catabase.server.dao.dao;

import com.catabase.server.model.UserAccount;

import java.sql.SQLException;

public interface UserAccountDao {
    public UserAccount getUserAccountInfo(int userId) throws SQLException;


}
