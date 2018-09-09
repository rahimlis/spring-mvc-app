package com.bakudynamics.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class OfferDao {

    private NamedParameterJdbcTemplate jdbc;

    public OfferDao() {
        System.out.println("Successfully created OffersDao");
    }

    public List<Offer> offers() {

        return jdbc.query("select * from offers,users where offers.username=users.username", (resultSet, rowNum) -> getOfferFromResultSet(resultSet));
    }

    public boolean create(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
        return jdbc.update("insert into offers (text,username) values (:text,:username)", params) == 1;
    }

    public int[] create(List<Offer> offers) {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
        return jdbc.batchUpdate("insert into offers(text,username) values (:text,:username)", params);
    }

    /**
     * Fetches offer with specified id from database and returns as a bean
     *
     * @param id of the offer
     * @return Offer object with specified id, null if object with this id doesn't exist
     */
    public Offer offer(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        return jdbc.queryForObject("select * from offers where id = :id", params, (resultSet, i) ->
                getOfferFromResultSet(resultSet));
    }

    private Offer getOfferFromResultSet(ResultSet resultSet) throws SQLException {
        Offer offer = new Offer();
        User user = extractUser(resultSet);
        offer.setId(resultSet.getInt("id"));
        offer.setText(resultSet.getString("text"));
        offer.setUser(user);
        return offer;
    }

    private User extractUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setAuthority(resultSet.getString("authority"));
        user.setEmail(resultSet.getString("email"));
        user.setName(resultSet.getString("name"));
        user.setUsername(resultSet.getString("username"));
        user.setEnabled(resultSet.getBoolean("enabled"));
        return user;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
}
