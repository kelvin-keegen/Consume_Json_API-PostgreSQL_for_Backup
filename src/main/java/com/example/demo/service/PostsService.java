package com.example.demo.service;

import com.example.demo.entity.Posts;
import com.example.demo.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostsService {

    private final PostsRepository repository;


    public List<Posts> GetAllDatabaseData() {

        return repository.findAll();
    }
}
