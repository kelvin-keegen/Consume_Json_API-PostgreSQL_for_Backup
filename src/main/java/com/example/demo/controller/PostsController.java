package com.example.demo.controller;

import com.example.demo.entity.Posts;
import com.example.demo.repository.PostsRepository;
import com.example.demo.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class PostsController {

    private final PostsService postsService;


    @GetMapping(path = "/get")
    public List<Posts> GetData() {

        return postsService.GetAllDatabaseData();

    }
}
