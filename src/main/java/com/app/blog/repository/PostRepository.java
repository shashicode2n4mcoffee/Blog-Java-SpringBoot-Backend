package com.app.blog.repository;

import com.app.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    @Query("SELECT p FROM Post p WHERE p.user.userId = :userId AND p.tagId = :tagId")
//    List<Post> findPostByUserIdAndTagId(@Param("userId") Long userId, @Param("tagId") Long tagId);
}
