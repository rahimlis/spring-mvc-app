package com.bakudynamics.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserDao {

    private NamedParameterJdbcTemplate jdbc;
    private PasswordEncoder passwordEncoder;

    public UserDao() {
        System.out.println("Successfully created UsersDao");
    }

    @Transactional
    public boolean create(User user) {
        //BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("username", user.getUsername());
        params.addValue("email", user.getEmail());
        params.addValue("name", user.getName());
        params.addValue("enabled", user.isEnabled());
        params.addValue("authority", user.getAuthority());
        params.addValue("password", passwordEncoder.encode(user.getPassword()));

        return jdbc.update("insert into users (username, name, password,email,enabled,authority) values (:username,:name,:password,:email,:enabled,:authority)", params) == 1;
    }


    public boolean exists(User user) {
        return jdbc.queryForObject("select count(*) from users where username=:username",
                new MapSqlParameterSource("username", user.getUsername()),
                Integer.class) > 0;
    }

    public List<User> getUsers() {
        return jdbc.query("select * from users",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
