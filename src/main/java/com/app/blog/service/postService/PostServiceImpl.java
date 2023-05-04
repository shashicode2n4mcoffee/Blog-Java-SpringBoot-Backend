package com.app.blog.service.postService;

import com.app.blog.dto.PostDto;
import com.app.blog.dto.TagDto;
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
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
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
    public List<Post> getAllPostsByUserAndTag(Long userId, Long tagId) {
        User fetchedUser = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found"));
        Tags fetchedTag = tagRepository.findById(tagId).orElseThrow(()->new ResourceNotFoundException("Tag not found"));
        List<Post> postList = postRepository.findPostByUserAndTag(fetchedUser,fetchedTag);
        if(postList.isEmpty()){
            throw  new ResourceNotFoundException("Post not found");
        }
        return postList;
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
    public Post updatePost(Long postId, Map<String, Object> updates) {
        Post fetchedPost = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found"));

        updates.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Tags.class, key);
            if (field != null && value != null){
                field.setAccessible(true);
                ReflectionUtils.setField(field,fetchedPost,value);
            }
        });

        return postRepository.save(fetchedPost);
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found"));
    }

    @Override
    public String deletePostById(Long postId) {
        postRepository.delete(postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found")));
        return "Post successfully deleted";
    }

    @Override
    public List<Post> getAllPostsByUser(Long userId) {
        User fetchedUser = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found"));
        return postRepository.findPostByUser(fetchedUser).orElseThrow(()->new ResourceNotFoundException("Posts not found"));
    }

    @Override
    public List<Post> getAllPostsByTag(Long tagId) {
        Tags fetchedTag = tagRepository.findById(tagId).orElseThrow(()->new ResourceNotFoundException("Tag not found"));
        return postRepository.findPostByTag(fetchedTag).orElseThrow(()->new ResourceNotFoundException("Post not found"));
    }

    @Override
    public List<Post> searchPosts(String searchValue) {
        return null;
    }
}
