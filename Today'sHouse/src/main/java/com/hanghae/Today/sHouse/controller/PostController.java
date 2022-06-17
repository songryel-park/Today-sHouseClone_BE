package com.hanghae.Today.sHouse.controller;

import com.hanghae.Today.sHouse.dto.PostDto;
import com.hanghae.Today.sHouse.model.Post;
import com.hanghae.Today.sHouse.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@ResponseStatus(HttpStatus.OK)
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getAllPost(@RequestHeader("Authorization") String user){
        return postService.getAllPost();
    }

    @GetMapping("/posts/{id}")
    public PostDto getPost(@PathVariable Long id) {
        Post post = postService.getPost(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다."));
        return PostDto.from(post);
    }
}
