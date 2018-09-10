package com.bakudynamics.mvc.dao.mappers;

import com.bakudynamics.mvc.dao.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setAuthority(resultSet.getString("authority"));
        user.setEmail(resultSet.getString("email"));
        user.setName(resultSet.getString("name"));
        user.setUsername(resultSet.getString("username"));
        user.setEnabled(resultSet.getBoolean("enabled"));
        return user;
    }

}
