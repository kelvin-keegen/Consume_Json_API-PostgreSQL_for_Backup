package com.example.demo.configs;

import com.example.demo.entity.Posts;
import com.example.demo.repository.PostsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Configuration
@AllArgsConstructor
public class PostReturn {

    private final PostsRepository postsRepository;

    private static final String Link = "https://jsonplaceholder.typicode.com/posts";

    @Bean
    public String GetInternetData() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(Link))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Running");

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Posts>> reference = new TypeReference<>(){};
        List<Posts> listofPosts = objectMapper.readValue(response.body(),reference);

        listofPosts.forEach(System.out::println);

        postsRepository.saveAll(listofPosts);


        return response.body();
    }




}
