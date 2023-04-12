package com.instagram.instagramclonecoding.config;

//import org.springframework.security.WebSecurityConfigurerAdapter
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity //해당 파일로 시큐리티를 활성화
@Configuration //IoC
public class SecurityConfig extends WebSecurityConfigurerAdapter {

}
