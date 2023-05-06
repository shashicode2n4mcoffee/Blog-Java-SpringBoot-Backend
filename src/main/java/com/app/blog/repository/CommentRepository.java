package com.app.blog.repository;

import com.app.blog.entity.Comment;
import com.app.blog.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByCommentTitle(String commentTitle);
}
