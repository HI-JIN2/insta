package com.instagram.instagramclonecoding.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //1. IoC 2. 파일을 리턴하는 컨트롤러
public class AuthController {

    @GetMapping("/auth/signin")
    public String signinForm(){
        return "auth/signin"; //같은 부분을 매핑하고 있으면 오류가 뜬다
    }

    @GetMapping("/auth/signup")
    public String signupForm(){
        return "auth/signup"; //같은 부분을 매핑하고 있으면 오류가 뜬다
    }

    @PostMapping("/auth/signup")
    public String signup(){
        return "auth/signin"; //회원가입 진행 후 로그인 페이지로
    }

}
