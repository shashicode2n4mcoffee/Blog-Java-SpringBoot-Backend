package com.app.blog.service.commentService;

import com.app.blog.dto.TagDto;
import com.app.blog.entity.Comment;
import com.app.blog.entity.Tags;
import com.app.blog.exception.ResourceAlreadyExistsException;
import com.app.blog.exception.ResourceNotFoundException;
import com.app.blog.repository.CommentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {

        List<Comment> commentsList = commentRepository.findAll();
        return commentsList;

    }

    @Override
    public Comment addComment(Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        return savedComment;
    }


    @Override
    public Comment updateComment(Map<String, Object> updateComment, Long commentId) {

        Comment fetchedComment = commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment not found"));

        updateComment.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Tags.class, key);
            if (field != null && value != null){
                field.setAccessible(true);
                ReflectionUtils.setField(field,fetchedComment,value);
            }
        });

        Comment savedComment = commentRepository.save(fetchedComment);
        return savedComment;
    }

    @Override
    public Comment getCommentById(Long commentId) {
        Comment fetchComment = commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Tag not found"));
        return fetchComment;
    }

    @Override
    public void deleteComment(Long tagId) {
        Comment fetchComment = commentRepository.findById(tagId).orElseThrow(()-> new ResourceNotFoundException("Tag not found"));
        commentRepository.delete(fetchComment);
    }
}
