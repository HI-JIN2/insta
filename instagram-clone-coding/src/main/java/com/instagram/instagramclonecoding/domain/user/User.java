package com.instagram.instagramclonecoding.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//JPA- Java Persistence API (자바로 데이터를 영구적으로 저장(DB)할 수 있는 API를 제공)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String name;
    private String website;
    private String bio;
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
