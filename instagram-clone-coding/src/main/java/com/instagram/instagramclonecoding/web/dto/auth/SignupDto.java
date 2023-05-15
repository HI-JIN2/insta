package com.instagram.instagramclonecoding.web.dto.auth;

import com.instagram.instagramclonecoding.domain.user.User;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupDto {

    @Max(20)
    private String username;
    @NotBlank //무조건 받아야하는 값
    private String password;
    @NotBlank
    private String email;

    private String name;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    } //user 객체가 만들어짐
}
