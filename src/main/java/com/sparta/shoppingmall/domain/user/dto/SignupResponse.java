package com.sparta.shoppingmall.domain.user.dto;

import com.sparta.shoppingmall.domain.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignupResponse {

    private final Long id;
    private final String username;
    private final String name;
    private final String email;
    private final String address;
    private final LocalDateTime createAt;
    private final LocalDateTime updateAt;


    public SignupResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.createAt = user.getCreateAt();
        this.updateAt = user.getUpdateAt();
    }
}
