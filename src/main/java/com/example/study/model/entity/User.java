package com.example.study.model.entity;

import com.example.study.model.enumclass.UserStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data // 객체사용 //get,set
@AllArgsConstructor //모든 매개변수 가지는 생성
@NoArgsConstructor //기본 생성자
@Entity // ==table //해당 Class가 Entity 임을 명시 // JPA에서는 테이블을 자동으로 생성해주는 기능 존재 // @Table -> 클래스명이 테이블 명과 일치하다면 자동 매칭 //실제 DB테이블의 이름을 명시 //DB Table == JPA Entity
@ToString(exclude = {"orderGroupList"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class User {

    @Id //Index primary key를 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key 식별키의 전략 설정
    private Long id;
    
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status; //REGISTERED / UNREGISTERED / WAITING

    // @Column (name = "account") -> database의 컬럼명과 변수명 일치하다면 쓰지 않아도 됨
    // 실제 DB Column의 이름을 명시
    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // User 1 : OrderGroup N // 유저 입장에서 유저는 하나 ordergroup은 다수
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;


    //1:N // 자신(User입장) 1 OrderDetail N
 /*   @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderDetail> orderDetailList; //OrderDetail이라는 클래스안에 user라는 변수에 매핑시키겠다*/
}
