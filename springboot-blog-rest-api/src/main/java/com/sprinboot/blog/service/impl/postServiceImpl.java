package com.sprinboot.blog.service.impl;


import com.sprinboot.blog.entity.Post;
import com.sprinboot.blog.payload.postDto;
import com.sprinboot.blog.repository.PostRepository;
import com.sprinboot.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class postServiceImpl implements PostService {

    private PostRepository postRepository;

    public postServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public postDto createPost(postDto poDto) {
//        //convert DTO to entity
//        Post post=new Post();
//        post.setTitle(poDto.getTitle());
//        post.setDescription(poDto.getDescription());
//        post.setContent(poDto.getContent());
        Post post=mapToEntity(poDto);
        Post newPost= postRepository.save(post);
       //convert entity to DTO
        postDto postResponse= mapToDTO(newPost);
        return postResponse;
    }

    @Override
    public List<postDto> getAllPosts() {
        List <Post> posts=postRepository.findAll();
        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList()) ;

    }
    //convert entity into Dto
    private postDto mapToDTO(Post post){
        postDto poDto=new postDto();
        poDto.setId(post.getId());
        poDto.setTitle(post.getTitle());
        poDto.setDescription(post.getDescription());
        poDto.setContent(post.getContent());
        return  poDto;
    }

    //convereted dto to entity
    private Post mapToEntity(postDto poDto){
        Post post= new Post();
        post.setTitle(poDto.getTitle());
        post.setDescription(poDto.getDescription());
        post.setContent(poDto.getContent());
        return post;
    }
}
