package com.app.blog.repository;

import com.app.blog.entity.Post;
import com.app.blog.entity.Tags;
import com.app.blog.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    @Query("SELECT p, u FROM Post p JOIN p.user.userId = :userId JOIN p.tag.tagId = :tagId")
    List<Post> findPostByUserAndTag(User user, Tags tag);

    Optional<List<Post>> findPostByUser(User user);

    Optional<List<Post>> findPostByTag(Tags tag);

    Optional<List<Post>> findByPostTitleContaining(String keyword);
}
