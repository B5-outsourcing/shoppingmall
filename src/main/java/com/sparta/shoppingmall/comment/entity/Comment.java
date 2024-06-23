package com.sparta.shoppingmall.comment.entity;

import com.sparta.shoppingmall.base.entity.Timestamped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    // product 테이블 외래키 참조 Comment , product N:1 관계
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    //user 테이블 외래키 참조 Comment, User N:1 관계
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(String content, Product product, User user/*, jwt로 받은 유저아이디 */) {
        this.content = content;
        this.product = product;
        this.user = user;
    }

    public void changeComment(String content) {
        this.content = content;

    }
}
