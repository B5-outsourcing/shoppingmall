package com.sparta.shoppingmall.order.entity;

import com.sparta.shoppingmall.base.entity.Timestamped;
import com.sparta.shoppingmall.order.status.OrderStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id")
    //private User user;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PAYING;

    @Builder
    public Order(/*User user,*/ String address, int totalPrice) {
        /*this.user = user;*/
        this.address = address;
        this.totalPrice = totalPrice;
    }

    public void approvedStatus(){this.status = OrderStatus.APPROVED;}
    public void canceledStatus(){this.status = OrderStatus.CANCELED;}
}