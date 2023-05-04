package com.app.blog.service.postService;

import com.app.blog.dto.PostDto;
import com.app.blog.entity.Post;
import com.app.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;


    @Override
    public List<Post> getAllPostsByUserIdAndTagId(Long userId, Long tagId) {
        return postRepository.findPostByUserIdAndTagId(userId,tagId);
    }

    @Override
    public Post addPost(Long userId, Long tagId, PostDto postDto) {
        return null;
    }

    @Override
    public Post updatePost(Long userId, Long tagId, Map<String, Object> updates) {
        return null;
    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }

    @Override
    public String deletePostById(Long postId) {
        return null;
    }

    @Override
    public List<Post> getAllPostsByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Post> getAllPostsByTagid(Long tagId) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String searchValue) {
        return null;
    }
}
