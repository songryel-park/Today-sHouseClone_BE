package com.hanghae.Today.sHouse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(nullable = false)
    private String imageFile;

    @Column(nullable = false)
    private String content;

    @Builder
    public Post(User user, String imageFile, String content) {
        this.user = user;
        this.imageFile = imageFile;
        this.content = content;
    }
}
