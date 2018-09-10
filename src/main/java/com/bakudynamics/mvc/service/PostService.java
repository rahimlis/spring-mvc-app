package com.bakudynamics.mvc.service;

import com.bakudynamics.mvc.dao.Offer;
import com.bakudynamics.mvc.dao.OfferDao;
import com.bakudynamics.mvc.dao.Post;
import com.bakudynamics.mvc.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostDao postDao;

    public List<Post> getPosts() {
        return postDao.posts();
    }

    public Post getPost(int id) {
        return postDao.post(id);
    }

    public void create(Post post) {
        postDao.create(post);
    }

    @Autowired
    public void setOfferDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
