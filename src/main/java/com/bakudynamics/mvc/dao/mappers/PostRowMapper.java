package com.bakudynamics.mvc.dao.mappers;

import com.bakudynamics.mvc.dao.Offer;
import com.bakudynamics.mvc.dao.Post;
import com.bakudynamics.mvc.dao.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Post post = new Post();
        User user = new UserMapper().mapRow(resultSet, rowNum);

        post.setId(resultSet.getInt("id"));
        post.setTitle(resultSet.getString("title"));
        post.setText(resultSet.getString("text"));
        post.setImageUrl(resultSet.getString("image_url"));
        post.setTimestamp(resultSet.getDate("timestamp"));
        post.setUser(user);

        return post;
    }
}
