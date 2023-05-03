package com.app.blog.service.postService;

import com.app.blog.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post addPost(Post post);

}
