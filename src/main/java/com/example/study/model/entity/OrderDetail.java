package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // order_detail
@ToString(exclude = {"user","item"}) //연관관계에 있는 데이터 해당
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    //N : 1  //자신(OrderDetail의 입장)은N 유저는 1
    @ManyToOne
    private User user; //private Long userId;

    //N : 1  //자신(OrderDetail의 입장)은N 유저는 1
    @ManyToOne
    private Item item; //private Long itemId;
}
