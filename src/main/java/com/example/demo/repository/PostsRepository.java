package com.example.demo.repository;

import com.example.demo.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Long> {

    Optional<Posts> findById(Long id);

}
