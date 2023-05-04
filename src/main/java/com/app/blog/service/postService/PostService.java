package com.app.blog.service.postService;

import com.app.blog.dto.PostDto;
import com.app.blog.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PostService {

    List<Post> getAllPostsByUserAndTag(Long userId, Long tagId);

    Post addPost(Long userId, Long tagId, PostDto postDto);

    Post updatePost(Long postId, Map<String, Object>updates);

    Post getPostById(Long postId);

    String deletePostById(Long postId);

    List<Post> getAllPostsByUser(Long userId);


    List<Post> getAllPostsByTag(Long tagId);


    List<Post> searchPosts(String searchValue);

}
