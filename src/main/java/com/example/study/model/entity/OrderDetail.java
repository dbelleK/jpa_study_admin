package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.criterion.Order;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // order_detail
@ToString(exclude = {"orderGroup","item"}) //연관관계에 있는 데이터 해당
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    //private Long itemId;

    //private Long orderGroupId;

    //OrderDetail N : OrderGroup 1
    @ManyToOne
    private OrderGroup orderGroup;

    //OrderDetail N : Item 1
    @ManyToOne
    private Item item;


/*    //N : 1  //자신(OrderDetail의 입장)은N 유저는 1
    @ManyToOne
    private User user; //private Long userId;

    //N : 1  //자신(OrderDetail의 입장)은N 유저는 1
    @ManyToOne
    private Item item; //private Long itemId;*/


}
