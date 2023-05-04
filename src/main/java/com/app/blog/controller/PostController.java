package com.app.blog.controller;

import com.app.blog.entity.Post;
import com.app.blog.service.postService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/users/{userId}/tag/{tagId}")
    ResponseEntity<List<Post>> addPost(@PathVariable("userId") Long userId, @PathVariable("tagId") Long tagId){
        List<Post> postList = postService.getAllPostsByUserIdAndTagId(userId,tagId);
        if(postList.isEmpty()){
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(postList);
    }



}
