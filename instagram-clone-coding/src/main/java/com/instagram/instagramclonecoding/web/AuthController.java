package com.instagram.instagramclonecoding.web;

import com.instagram.instagramclonecoding.domain.user.User;
import com.instagram.instagramclonecoding.handler.ex.CustomValidationException;
import com.instagram.instagramclonecoding.web.dto.auth.SignupDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AuthService;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor //final 필드를 DI할 때 사용(final에 대한 모든 생성자를 만들어줌)
@Controller //1. IoC 2. 파일을 리턴하는 컨트롤러
public class AuthController {

    private static final Logger log= LoggerFactory.getLogger(AuthController.class);

    //@Autowired
    private final AuthService authService;

//    public AuthController(AuthService authService){ //의존성 주입
//        this.authService=authService;
//    }
    
    @GetMapping("/auth/signin")
    public String signinForm(){
        return "auth/signin"; //같은 부분을 매핑하고 있으면 오류가 뜬다
    }

    @GetMapping("/auth/signup")
    public String signupForm(){
        return "auth/signup"; //같은 부분을 매핑하고 있으면 오류가 뜬다
    }

    //회원가입 버튼 -> /auth/signup ->/auth/signin
    //회원가입 버튼 x
    @PostMapping("/auth/signup")
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) { //key=value
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
                System.out.println(error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성 검사 실패함",errorMap);
        } else {
//        System.out.println("signup 실행됨?");
//        log.info(signupDto.toString());
            //User<-Signupdto

            //validation check
            if (signupDto.getUsername().length() > 20) {
                System.out.println("너 길이 초과했어");
            }

            User user = signupDto.toEntity();
            log.info(user.toString());
            User userEntity = authService.회원가입(user);
            //System.out.println(userEntity);

            return "auth/signin"; //회원가입 진행 후 로그인 페이지로
        }
    }
}
