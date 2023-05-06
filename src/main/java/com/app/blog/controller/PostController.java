package com.app.blog.controller;

import com.app.blog.config.AppConstants;
import com.app.blog.dto.PostDto;
import com.app.blog.dto.PostResponse;
import com.app.blog.entity.Post;
import com.app.blog.service.postService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/users/{userId}/tag/{tagId}")
    ResponseEntity<List<Post>> getPostByUserIdAndTagId(@PathVariable("userId") Long userId, @PathVariable("tagId") Long tagId){
        List<Post> postList = postService.getAllPostsByUserAndTag(userId,tagId);
        if(postList.isEmpty()){
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(postList);
    }

    @PostMapping("/users/{userId}/tag/{tagId}")
    ResponseEntity<Post> addPost(@PathVariable("userId") Long userId, @PathVariable("tagId") Long tagId, @RequestBody PostDto postDto){
        Post post = postService.addPost(userId, tagId, postDto);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/users/{userId}")
    ResponseEntity<List<Post>> getPostsbyUser(@PathVariable("userId") Long userid){
        List<Post> postList = postService.getAllPostsByUser(userid);
        return ResponseEntity.ok(postList);
    }

    @GetMapping("/tags/{tagId}")
    ResponseEntity<List<Post>> getPostsByTag(@PathVariable("tagId") Long tagId){
        List<Post> postList = postService.getAllPostsByTag(tagId);
        return ResponseEntity.ok(postList);
    }

    @DeleteMapping("/{postId}")
    ResponseEntity<String> deletePostById(@PathVariable("postId") Long postId){
        postService.deletePostById(postId);
        return ResponseEntity.ok("Delete Post successfully");
    }

    @PatchMapping("/{postId}")
    ResponseEntity<Post> updatePostByPostId(@PathVariable("postId") Long postId, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(postService.updatePost(postId, updates));
    }

    @GetMapping("/search/{search}")
    ResponseEntity<List<Post>> getPostBySearchTitle(@PathVariable("search") String search){
        System.out.println("SEARCH KEYWORD : " +  search);
        return ResponseEntity.ok(postService.getAllPostsBySearch(search));
    }


    @GetMapping()
    ResponseEntity<PostResponse> getAllPost(@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) int pageNumber,
                                            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) int pageSize,
                                            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORTBY, required = false) String sortBy,
                                            @RequestParam(value = "orderBy", defaultValue = AppConstants.ORDERBY, required = false) String orderBy){
        return ResponseEntity.ok(postService.getPostByPagination(pageSize, pageNumber, sortBy, orderBy));
    }
}
