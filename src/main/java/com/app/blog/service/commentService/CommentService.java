package com.app.blog.service.commentService;

import com.app.blog.entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Comment> getAllComments();
    Comment addComment(Comment comment);
    Comment updateComment(Map<String , Object>updateComment, Long userId);
    Comment getCommentById(Long commentId);
    void deleteComment(Long CommentId);

}
