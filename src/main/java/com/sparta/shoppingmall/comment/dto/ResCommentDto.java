package com.sparta.shoppingmall.comment.dto;

import com.sparta.shoppingmall.comment.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResCommentDto {
    Long id;

    Long userId;

    Long productId;

    String content;

    LocalDateTime updatedAt;


    public ResCommentDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.updatedAt = comment.getUpdateAt();
        this.userId = comment.getUser().getId();
        this.productId = comment.getProduct().getId();
    }


}
