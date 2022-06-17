package com.hanghae.Today.sHouse.service;

import com.hanghae.Today.sHouse.dto.PostDto;
import com.hanghae.Today.sHouse.model.Post;
import com.hanghae.Today.sHouse.model.Timestamped;
import com.hanghae.Today.sHouse.repository.PostRepository;
import com.hanghae.Today.sHouse.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Transactional
@RequiredArgsConstructor
public class PostService extends Timestamped {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public ResponseEntity<PostResponseDto> getAllPost() {
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostResponseDto> postResponse = new ArrayList<>();
        for (Post post : posts) {
            PostResponseDto postDto = PostResponseDto.builder().build();
            postResponse.add(postDto);
        }
        return new ResponseEntity(postResponse, HttpStatus.OK);
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }
}
