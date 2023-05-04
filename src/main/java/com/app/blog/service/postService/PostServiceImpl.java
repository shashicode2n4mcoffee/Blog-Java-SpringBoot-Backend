package com.app.blog.service.postService;

import com.app.blog.dto.PostDto;
import com.app.blog.entity.Post;
import com.app.blog.entity.Tags;
import com.app.blog.entity.User;
import com.app.blog.exception.ResourceNotFoundException;
import com.app.blog.repository.PostRepository;
import com.app.blog.repository.TagRepository;
import com.app.blog.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TagRepository tagRepository;


    @Override
    public List<Post> getAllPostsByUserIdAndTagId(Long userId, Long tagId) {
//        return postRepository.findPostByUserIdAndTagId(userId,tagId);
        return null;
    }

    @Override
    public Post addPost(Long userId, Long tagId, PostDto postDto) {


        User fetchedUser = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not Found"));
        Tags fetchedTag = tagRepository.findById(tagId).orElseThrow(()->new ResourceNotFoundException("Tag not found"));


        Post newPost = new Post();
        BeanUtils.copyProperties(postDto,newPost);
        newPost.setUser(fetchedUser);

        System.out.println("USER ID " + userId + "TAG ID " + tagId + newPost.toString());

        newPost.setTag(fetchedTag);
        return postRepository.save(newPost);
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
