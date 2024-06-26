package com.sparta.shoppingmall.domain.user.dto;

import com.sparta.shoppingmall.domain.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {

    private final Long id;

    private final String username;

    private final String email;

    private final String address;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.createdAt = user.getCreateAt();
        this.updatedAt = user.getUpdateAt();
    }
}
