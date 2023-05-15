package com.instagram.instagramclonecoding.domain.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//JPA- Java Persistence API (자바로 데이터를 영구적으로 저장(DB)할 수 있는 API를 제공)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true) //유저 이름에 대한 제약조건
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    private String website;
    private String bio;
    @Column(nullable = false)
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl;
    private String role; //권한

    private LocalDateTime createDate;

    @PrePersist //db에 INSERT
    public void createDate(){
        this.createDate=LocalDateTime.now();
    }
}
