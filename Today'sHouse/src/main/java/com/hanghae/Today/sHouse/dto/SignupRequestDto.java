package com.hanghae.Today.sHouse.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String nickname;
    private String password;
}