package com.catabase.server.dao.jdbc;

import com.catabase.server.dao.dao.UserAccountDao;
import com.catabase.server.model.User;
import com.catabase.server.model.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class JdbcUserAccountDao implements UserAccountDao {

    private static final Logger log = LoggerFactory.getLogger(JdbcUserAccountDao.class);
    private JdbcTemplate jdbcTemplate;

    public JdbcUserAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserAccount getUserAccountInfo(int userId) throws SQLException {
        String SQL = "SELECT user_id, balance, owns_other_pets, user_age, activity_level, works_from_home, user_address, user_state_province, user_country " +
                "FROM user_account " +
                "WHERE user_id = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(SQL, userId);
        if (sqlRowSet.next()){
            return mapRoadToObject(sqlRowSet);
        }
        else{
            throw new SQLException();
        }
    }
    private UserAccount mapRoadToObject(SqlRowSet rowSet){
        UserAccount user = new UserAccount();
        user.setUserAge(rowSet.getInt("user_age"));
        user.setUserId(rowSet.getInt("user_id"));
        user.setBalance(rowSet.getBigDecimal("balance"));
        user.setOwnsOtherPets(rowSet.getBoolean("owns_other_pets"));
        user.setActivityLevel(rowSet.getString("activity_level"));
        user.setWorksFromHome(rowSet.getBoolean("works_from_home"));
        user.setUserAddress(rowSet.getString("user_address"));
        user.setUserStateProvince(rowSet.getString("user_state_province"));
        user.setUserCountry(rowSet.getString("user_country"));
        user.setUserName(rowSet.getString("user_name"));
        return user;
    }
}
