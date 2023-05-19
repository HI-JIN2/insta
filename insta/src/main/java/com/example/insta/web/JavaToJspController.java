package com.example.insta.web;

import com.example.insta.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaToJspController {

    @GetMapping("/jsp/java")
    public String jspTpJava(){
        return "b";
    }

    @GetMapping("/jsp/java/model")
    public String jspToJavaModel(Model model){
        User user= new User();
        user.setUsername("ssar");

        model.addAllAttributes("username",user.getUsername());

        return "e";
    }
}
