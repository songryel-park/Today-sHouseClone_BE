package com.hanghae.Today.sHouse.dto;

import com.hanghae.Today.sHouse.model.Post;
import com.hanghae.Today.sHouse.model.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto extends Timestamped {
    private Long id;

    private String imageFile;

    private String nickname;

    private String content;

    private LocalDateTime createdDate;

    public static PostDto from(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .imageFile(post.getImageFile())
                .nickname(post.getUser().getNickname())
                .content(post.getContent())
                .createdDate(post.getCreatedDate())
                .build();
    }
}
