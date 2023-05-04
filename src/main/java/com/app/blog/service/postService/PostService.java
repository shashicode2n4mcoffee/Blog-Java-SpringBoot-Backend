package com.app.blog.service.postService;

import com.app.blog.dto.PostDto;
import com.app.blog.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PostService {

    List<Post> getAllPostsByUserIdAndTagId(Long userId, Long tagId);

    Post addPost(Long userId, Long tagId, PostDto postDto);

    Post updatePost(Long userId, Long tagId, Map<String, Object>updates);

    Post getPostById(Long postId);

    String deletePostById(Long postId);

    List<Post> getAllPostsByUserId(Long userId);

    List<Post> getAllPostsByTagid(Long tagId);

    List<Post> searchPosts(String searchValue);

}
