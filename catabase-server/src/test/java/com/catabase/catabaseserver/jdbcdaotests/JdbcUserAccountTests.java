package com.catabase.catabaseserver.jdbcdaotests;


import com.catabase.catabaseserver.BaseDaoTests;
import com.catabase.catabaseserver.dao.JdbcUserAccountDao;
import com.catabase.catabaseserver.model.UserAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.sql.SQLException;

public class JdbcUserAccountTests extends BaseDaoTests {

    private static final UserAccount USER_ACCOUNT = new UserAccount(1, "Testerson mCuser", BigDecimal.valueOf(500), true, 37, "Highly active", true,
            "430 Test Lane", "OH", "USA");
    private JdbcUserAccountDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcUserAccountDao(jdbcTemplate);
    }

    @Test
    public void test_for_get_user_account_data() throws SQLException {
        UserAccount userAccount = dao.getUserAccountInfo(1);
        Assert.assertEquals(USER_ACCOUNT.getUserId(), userAccount.getUserId());
        Assert.assertEquals(USER_ACCOUNT.getUserName(), userAccount.getUserName());
        Assert.assertEquals(USER_ACCOUNT.getBalance().setScale(2), userAccount.getBalance().setScale(2));
        Assert.assertTrue(userAccount.isOwnsOtherPets());
    }

}
