package com.app.blog.controller;

import com.app.blog.entity.Post;
import com.app.blog.service.postService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;
    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);
    }


}
