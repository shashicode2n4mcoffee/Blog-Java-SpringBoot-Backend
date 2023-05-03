package com.app.blog.repository;

import com.app.blog.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tags, Long> {

    Optional <Tags> findByTagTitle(String tagTitle);
}
