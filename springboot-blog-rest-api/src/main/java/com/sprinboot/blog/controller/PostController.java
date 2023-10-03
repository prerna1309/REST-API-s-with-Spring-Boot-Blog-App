package com.sprinboot.blog.controller;

import com.sprinboot.blog.payload.postDto;
import com.sprinboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create blog post
    @PostMapping()
    public ResponseEntity<postDto> createPost(@RequestBody postDto poDto){
        return new ResponseEntity<>(postService.createPost(poDto), HttpStatus.CREATED);
    }

    //get all posts rest api
    @GetMapping
    public List<postDto> getAllPosts(){
        return postService.getAllPosts();
    }
}
