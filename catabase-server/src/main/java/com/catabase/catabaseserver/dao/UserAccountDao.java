package com.catabase.catabaseserver.dao;

import com.catabase.catabaseserver.model.UserAccount;

import java.sql.SQLException;

public interface UserAccountDao {
    public UserAccount getUserAccountInfo(int userId) throws SQLException;


}
