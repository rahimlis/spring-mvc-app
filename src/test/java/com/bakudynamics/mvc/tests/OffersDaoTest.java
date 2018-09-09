package com.bakudynamics.mvc.tests;

import com.bakudynamics.mvc.dao.Offer;
import com.bakudynamics.mvc.dao.OfferDao;
import com.bakudynamics.mvc.dao.User;
import com.bakudynamics.mvc.dao.UserDao;
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
public class OffersDaoTest {

    @Autowired
    private UserDao usersDao;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private OfferDao offerDao;

    @Before
    public void init() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("delete from offers");
        jdbcTemplate.execute("delete from users");
    }

    @Test
    public void testOfferDao() {
        User user = new User("rahimlis", "Rahim Rahimli", "rahim@mail.ru",
                "hellothere", true, "user");
        assertTrue("User creation should be done", usersDao.create(user));

        Offer offer = new Offer(user, "Sample text for test");

        assertTrue("Offer creation should be true", offerDao.create(offer));

        List<Offer> offers = offerDao.offers();

        assertEquals("Offers table should contain one record", 1, offers.size());

    }
}
