package com.sparta.shoppingmall.comment.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


}
