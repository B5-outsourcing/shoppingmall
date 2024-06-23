package com.sparta.shoppingmall.comment.commentController;


import com.sparta.shoppingmall.comment.dto.ReqCommentDto;
import com.sparta.shoppingmall.comment.dto.ResCommentDto;
import com.sparta.shoppingmall.comment.entity.Comment;
import com.sparta.shoppingmall.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    //Comment Create
    @PostMapping("/products/{productId}/reviews")
    public ResponseEntity<ResCommentDto> writeComment(
            @PathVariable Long productId,
            @RequestBody ReqCommentDto reqCommentDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(commentService.createComment(productId, reqCommentDto));
    }

    //Comment Update
    @PutMapping("/products/{productId}/reviews/{reviewId}")
    public ResponseEntity<ResCommentDto> updateComment(
            @PathVariable Long productId,
            @PathVariable Long reviewId,
            @RequestBody ReqCommentDto reqCommentDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.updateComment(productId, reviewId, reqCommentDto));
    }

    //Comment Delete ( Hard Delete );

    @DeleteMapping("/products/{productId}/reviews/{reviewId}")
    public ResponseEntity<?> deleteComment(
            @PathVariable Long productId,
            @PathVariable Long reviewId) {
        commentService.deleteComment(productId, reviewId);
        return ResponseEntity.status(HttpStatus.OK).body("삭제가 완료 되었습니다.");
    }

    //Comment ReadByUserId

    @GetMapping("/products/{productId}/reviews")
    public ResponseEntity<List<Comment>> readCommentByUser(
            @PathVariable Long productId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.readCommentByUser(productId));
    }
}
