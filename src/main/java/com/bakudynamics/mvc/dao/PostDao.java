package com.bakudynamics.mvc.dao;


import com.bakudynamics.mvc.dao.mappers.OfferRowMapper;
import com.bakudynamics.mvc.dao.mappers.PostRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class PostDao {

    private NamedParameterJdbcTemplate jdbc;

    public boolean create(Post post) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(post);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        boolean updated = jdbc.update("insert into posts (title, text, username) values (:title, :text, :username)", params, keyHolder) == 1;
        post.setId(keyHolder.getKey().intValue());
        System.out.println("New Post id: " + post.getId());
        return updated;
    }


    public List<Post> posts() {

        return jdbc.query("select * from posts,users where posts.username=users.username and users.enabled=1",
                new PostRowMapper());
    }

    public List<Post> posts(String username) {

        return jdbc.query("select * from posts,users where posts.username=users.username and users.enabled=1 " +
                        "and posts.username=:username", new MapSqlParameterSource("username", username),
                new PostRowMapper());
    }


    public Post post(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        return jdbc.queryForObject("select * from posts,users where posts.username=users.username" +
                " and users.enabled=1 and id = :id", params, new PostRowMapper());
    }


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }


}
