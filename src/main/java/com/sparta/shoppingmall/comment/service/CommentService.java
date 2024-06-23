package com.sparta.shoppingmall.comment.service;


import com.sparta.shoppingmall.comment.dto.ReqCommentDto;
import com.sparta.shoppingmall.comment.dto.ResCommentDto;
import com.sparta.shoppingmall.comment.entity.Comment;
import com.sparta.shoppingmall.comment.entity.Product;
import com.sparta.shoppingmall.comment.entity.User;
import com.sparta.shoppingmall.comment.repository.CommentRepository;
import com.sparta.shoppingmall.comment.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;

    @Transactional
    public ResCommentDto createComment(Long id, ReqCommentDto reqCommentDto) {
        Product product = findProductId(id);
        User user = new User();
        // !! 유저객체를 새로 만들어서 받아오기때문에 유저의 ID가
        // Entity 설정을 따라서 늘어남 - jwt에서 유저 정보를 받아오면 늘어나지 않음
        // user id 는 jwt에서 받아옴
        if (!Objects.equals(product.getId(), id)) {
            throw new RuntimeException("해당하는 물품이 없습니다.");
        }
        Comment comment = new Comment(reqCommentDto.getComment(), product, user);

        commentRepository.save(comment);
        return new ResCommentDto(comment);
    }

    @Transactional
    public ResCommentDto updateComment(Long productId, Long reviewId, ReqCommentDto reqCommentDto) {
        Comment commentById = commentRepository.findCommentByIdAndProductId(reviewId, productId);
        User user = new User(); // jwt 에서 받아온 유저 아이디

        commentById.changeComment(reqCommentDto.getComment());

        commentRepository.save(commentById);
        return new ResCommentDto(commentById);
        //상품의 아이디 이면서, 코맨트의 아이디 인것
    }

    @Transactional
    public List<Comment> readCommentByUser(Long productId) {
        return commentRepository.findAllCommentByProductId(productId);
    }

    public void deleteComment(Long productId, Long reviewId) {
        commentRepository.deleteCommentByIdAndProductId(productId, reviewId);
    }

    public Product findProductId(Long productId) {
        return productRepository.findProductById(productId);
    }

    public Comment findCommentId(Long reviewId) {
        return commentRepository.findCommentById(reviewId);
    }
}








