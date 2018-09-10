package com.bakudynamics.mvc.dao.mappers;

import com.bakudynamics.mvc.dao.Offer;
import com.bakudynamics.mvc.dao.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferRowMapper implements RowMapper<Offer> {

    @Override
    public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Offer offer = new Offer();
        User user = new UserMapper().mapRow(resultSet, rowNum);
        offer.setId(resultSet.getInt("id"));
        offer.setText(resultSet.getString("text"));
        offer.setUser(user);
        return offer;
    }

}
