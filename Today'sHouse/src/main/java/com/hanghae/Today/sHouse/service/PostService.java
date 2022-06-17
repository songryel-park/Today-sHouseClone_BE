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

    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : posts) {
            PostDto postDto = PostDto.builder().build();
            postDtos.add(postDto);
        }
        return postDtos;
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }
}
