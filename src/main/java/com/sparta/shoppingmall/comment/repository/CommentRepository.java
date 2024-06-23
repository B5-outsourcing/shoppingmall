package com.sparta.shoppingmall.comment.repository;


import com.sparta.shoppingmall.comment.dto.ResCommentDto;
import com.sparta.shoppingmall.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentById(Long id);

    void deleteCommentByIdAndProductId(Long reviewId, Long productId);

    Comment findCommentByIdAndProductId(Long reviewId, Long productId);

    List<Comment> findAllCommentByProductId(Long productId);
}
