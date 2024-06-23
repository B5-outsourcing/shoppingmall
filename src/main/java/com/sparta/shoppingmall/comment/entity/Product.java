package com.sparta.shoppingmall.comment.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
//임시 product Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
}
