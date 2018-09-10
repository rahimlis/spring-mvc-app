package com.bakudynamics.mvc.controllers;


import com.bakudynamics.mvc.dao.Offer;
import com.bakudynamics.mvc.dao.Post;
import com.bakudynamics.mvc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class BlogController {

    private PostService postService;

    @RequestMapping("/blog")
    public String feed(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "blog/blog.feed";
    }

    @RequestMapping("/blog/post/{id}")
    public String viewPost(Model model, @PathVariable int id) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "blog/blog.post";
    }

    @RequestMapping("/posts/create")
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "blog/blog.post.create";
    }

    @RequestMapping(value = "/posts/store", method = RequestMethod.POST)
    public String storePost(Model model, @Valid Post post, BindingResult result, Principal principal) {
        System.out.println(post);

        if (result.hasErrors()) {

            return "blog/blog.post.create";
        }

        String username = principal.getName();
        post.getUser().setUsername(username);
        postService.create(post);

        return "blog/blog.post.created";
    }

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }
}
