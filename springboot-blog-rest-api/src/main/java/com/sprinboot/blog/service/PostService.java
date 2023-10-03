package com.sprinboot.blog.service;

import com.sprinboot.blog.payload.postDto;

import java.util.List;

public interface PostService {
    postDto createPost(postDto poDto);

    List<postDto> getAllPosts();
    postDto getPstById
}
