package com.instagram.instagramclonecoding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class ViewControllerTest {

    @GetMapping
    public String signupPage(){
        return "auth/signup";
    }

    @GetMapping
    public String signinPage(){
        return "auth/signin";
    }
}
