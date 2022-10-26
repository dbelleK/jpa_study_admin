package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data // 객체사용 //get,set
@AllArgsConstructor //모든 매개변수 가지는 생성
@Entity // ==table //해당 Class가 Entity 임을 명시 // JPA에서는 테이블을 자동으로 생성해주는 기능 존재
// @Table -> 클래스명이 테이블 명과 일치하다면 자동 매칭 //실제 DB테이블의 이름을 명시
//DB Table == JPA Entity

public class User {

    @Id //Index primary key를 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key 식별키의 전략 설정
    private Long id;

    // @Column (name = "account") -> database의 컬럼명과 변수명 일치하다면 쓰지 않아도 됨
    // 실제 DB Column의 이름을 명시
    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updateBy;

}