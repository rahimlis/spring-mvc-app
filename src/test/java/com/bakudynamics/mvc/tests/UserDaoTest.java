package com.bakudynamics.mvc.tests;

import com.bakudynamics.mvc.dao.User;
import com.bakudynamics.mvc.dao.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:config/dao-context.xml",
        "classpath:config/security-context.xml",
        "file:src/test/resources/test_datasource.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {

    @Autowired
    private UserDao usersDao;

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("delete from users");
    }

    @Test
    public void testCreateUser() {
        User user = new User("rahimlis", "Rahim Rahimli", "rahim@mail.ru",
                "hellothere", true, "user");
        assertTrue(usersDao.create(user));

        List<User> users = usersDao.getUsers();

        assertEquals("Numbers of users should be 1", 1, users.size());

        assertTrue("User should exist", usersDao.exists(user));

        assertEquals("Created user == retrieved", user, users.get(0));
    }
}
