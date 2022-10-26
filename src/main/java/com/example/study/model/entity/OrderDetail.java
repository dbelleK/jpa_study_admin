package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // order_detail
@ToString(exclude = {"orderGroup"}) //연관관계에 있는 데이터 해당
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private Long itemId;

    private Long orderGroupId;

    //OrderDetail N : OrderGroup 1
    @ManyToOne
    private OrderGroup orderGroup;


/*    //N : 1  //자신(OrderDetail의 입장)은N 유저는 1
    @ManyToOne
    private User user; //private Long userId;

    //N : 1  //자신(OrderDetail의 입장)은N 유저는 1
    @ManyToOne
    private Item item; //private Long itemId;*/


}
